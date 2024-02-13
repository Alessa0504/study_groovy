//脚本 extends Script
def username = "zhangsan"
println(username)

//类 implements GroovyObject
class Book {

}

//1. 闭包
def running = { who ->   //参数
    println("running start... ${who}")
    println("running end...")
}

//调用闭包
running(username)
//或
running.call("lisi")

//2. 闭包作为参数传入
def running02(Closure closure) {
    closure()
    println("running02 end")
}

running02 ({println("running02 closure")})

//3. 有参数闭包传入
def running03(Closure closure) {
    def num1 = 10
    def num2 = 15
    closure(num1, num2)
}

running03 ({num1, num2 -> println("running03 result =${num1+num2}")})

//4. 闭包作为最后一个参数，可以写在方法外部
def running04(num1, num2, Closure closure) {
    closure(num1, num2)
}

running04(14, 16) { num1, num2 ->
    println("running04 result =${num1 + num2}")
}

//Reference: https://www.bilibili.com/video/BV1yT41137Y7?p=17&vd_source=6c1b3915cb08c506647be7e9988933bf