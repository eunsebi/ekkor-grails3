package xyz.ekkor

class JobPositionDuty {

    String name

    static belongsTo = [group : JobPositionGroup]

    static constraints = {
    }
}
