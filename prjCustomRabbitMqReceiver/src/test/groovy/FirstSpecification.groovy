class FirstSpecification extends Specification {
    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    def "Should be able to remove from list"() {
        given:
        def list = [1, 2, 3, 4]

        when:
        list.remove(0)

        then:
        list == [2, 3, 4]
    }
}