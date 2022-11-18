//hw01-testrunner

fun main() {
    TestRun().runTest(steps = Steps(), test = {test()})


}

interface TestRunner {
    fun <T> runTest(steps: T, test: () -> Unit)
}

class TestRun: TestRunner {
    override fun <T> runTest(steps: T, test: () -> Unit) {
        val stepsBefore = Steps()
        val stepsAfter = Steps()
        stepsBefore.beforeTest()
        test()
        stepsAfter.afterTest()
    }
}

class Steps() {
    fun beforeTest (){
        println("Before test.")
    }
    fun afterTest () {
        println("After test.")
    }
}

fun test () {
    println("Test...")
}