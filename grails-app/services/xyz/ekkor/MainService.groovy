package xyz.ekkor

import grails.gorm.transactions.Transactional
import grails.plugin.cache.Cacheable
import grails.plugin.springsecurity.SpringSecurityService
import org.hibernate.FetchMode

@Transactional
class MainService {

    SpringSecurityService springSecurityService

    def serviceMethod() {
    }

    @Cacheable(value = "choiceArticlesCache")
    def getChoiceArticles() {
        Article.withCriteria() {
            fetchMode 'content', FetchMode.JOIN
            fetchMode 'author', FetchMode.JOIN
            eq('choice', true)
            eq('enabled', true)
            ne('category', Category.get('recruit'))
            ne('category', Category.get('resumes'))
            maxResults(5)
        }.findAll()
    }

    //
}
