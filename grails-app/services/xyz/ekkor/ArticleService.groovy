package xyz.ekkor

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService

@Transactional
class ArticleService {

    SpringSecurityService springSecurityService

    def changeLog(ChangeLogType type, Article articleInstance, Content contentInstance, String oldText, String text) {
        Avatar avatar = Avatar.load(springSecurityService.principal.avatarId)

        if (oldText) {
            def latestChangeLog = ChangeLog.createCriteria().get {
                eq('article', articleInstance)
                eq('content', contentInstance)
                order('revision', 'desc')
                maxResults(1)
            }

            def dmp = new diff_match_patch()

            def patches = dmp.patch_make(text, oldText)

            if (patches) {
                int revision = 1

                if (latestChangeLog) {
                    revision = latestChangeLog.revision+1
                }

                new ChangeLog(
                        type: type,
                        md5: oldText,encodeAsMD5(),
                        patch: dmp.patch_toText(patches),
                        article: articleInstance,
                        content: contentInstance,
                        avatar: avatar,
                        revision: revision
                ).save()
            }
        }
//
    }

    def serviceMethod() {

    }

    //
}
