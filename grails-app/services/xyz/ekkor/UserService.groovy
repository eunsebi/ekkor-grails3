package xyz.ekkor

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    EncryptService encryptService

    def grailsApplication

    /**
     * Save User with relationship
     * @param userInstance
     * @return
     */
    def saveUser(User userInstance) {
        userInstance.avatar.setPictureBySns(userInstance)

        // 유저 연관 정보 선 저장
        userInstance.person.save(failOnError: true)
        userInstance.avatar.save(failOnError: true)

        def result = userInstance.save(failOnError: true)

        // 유저 권한 생성
        UserRole.create(userInstance, Role.findByAuthority('ROLE_USER'), true)

        result
    }

    def serviceMethod() {

    }
}
