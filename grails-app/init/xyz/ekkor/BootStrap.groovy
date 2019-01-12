package xyz.ekkor

class BootStrap {

	UserService userService

    def init = { servletContext ->
			  
		//def roleAdmin = new Role(authority: 'ROLE_ADMIN').save()
		//def adminUser = new User(username: 'user', password: 'user').save()
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def classRole = new Role(authority: 'ROLE_CLASS').save(flush: true)
		def leaderRole = new Role(authority: 'ROLE_LEADER').save(flush: true)
		def maintRole = new Role(authority: 'ROLE_MAINT').save(flush: true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

		environments {
			development {
				if (!User.findByUsername('admin')) {

					// 관리자 아이디 생성
					def adminUser = new User(
							username: 'admin',
							password: 'admin',
							person: new Person(fullName: '관리자', email: 'admin@ekkor.xyz'),
							avatar: new Avatar(nickname: '관리자')
					)

					adminUser.enabled = true
					adminUser.createIp = '0.0.0.0'
					userService.saveUser adminUser
					UserRole.create(adminUser, adminRole, true)
				}

				UserRole.withSession {
					it.flush()
					it.clear()
				}
			}
		}

		println "criando usuários"
		def count = User.count()

		println "usuario ${count}"

    }
    def destroy = {
    }
}
