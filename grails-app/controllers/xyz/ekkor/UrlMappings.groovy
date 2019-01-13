package xyz.ekkor

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //"/"(controller: "main", action: 'index')

        //"/"(view:"/index")
        "/"(view:"/main/index")


        //추가
        "/user/privacy"(view: '/user/privacy')
        "/user/agreement"(view: '/user/agreement')

        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
