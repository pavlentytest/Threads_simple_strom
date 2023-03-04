fun main(args: Array<String>) {
    val thread1: MyThread = MyThread("+")
    val thread2: MyThread = MyThread("-")
    thread1.start()
    thread2.start()
}

val obj: Object = Object()

fun test(message: String) {
    synchronized(obj) {
        print("[")
        Thread.sleep(1000)
        print(message)
        Thread.sleep(1000)
        print("]")
        obj.notify()
        obj.wait()
    }
}
class MyThread(val mess: String) : Thread() {

    override fun run() {
        while(true) {
            test(mess)
        }
    }
}
