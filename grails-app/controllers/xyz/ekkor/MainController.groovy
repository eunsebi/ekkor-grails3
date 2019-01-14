package xyz.ekkor

class MainController {

    def mainService
    //def randomService

    def grailsCacheAdminService

    def index() {

        /*def mainBanners = Banner.where {
            type == BannerType.MAIN && visible == true
        }.list()

        def mainBanner = mainBanners ? randomService.draw(mainBanners) : null*/

        return [
                isIndex: true,
                choiceArticles: mainService.getChoiceArticles()
        ]
    }
    //

    def flush() {
        grailsCacheAdminService.clearAllCaches()
    }
}
