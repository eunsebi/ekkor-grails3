package xyz.ekkor

import grails.gorm.transactions.Transactional

@Transactional
class NotificationService {

    def count(Avatar avatar) {
        NotificationRead notificationRead = NotificationRead.findOrSaveByAvatar(avatar)

        def query = Notification.where {
            and {
                eq('receiver', avatar)
                gt('lastUpdated', notificationRead.lastRead)
            }
        }

        query.count()
    }

    def serviceMethod() {

    }
}
