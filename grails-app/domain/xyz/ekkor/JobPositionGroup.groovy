package xyz.ekkor

class JobPositionGroup {

    String name

    static hasMany = [duties : JobPositionDuty]

    static constraints = {
    }
}
