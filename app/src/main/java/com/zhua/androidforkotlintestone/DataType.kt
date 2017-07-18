package com.zhua.androidforkotlintestone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 数据类型
 */
class DataType : AppCompatActivity() {

    //basic type of char
    val aChar:Char = '0'
    val bChar:Char = '中'
    val cChar:Char = '\u000f'

    //basic type of string
    val FIANL_HELLOW_WORLD:String = "Hello World"
    var helloworld:String = "hello world"
    var nullableHelloWorld:String? = helloworld
    val helloworldArray:Array<Char> = arrayOf('H','e','l','l','o','W','o','r','l','d')
    val helloworldCharArray:CharArray = charArrayOf('H','e','l','l','o','W','o','r','l','d')
    val helloWorldLength:Int = helloworld.length
    val helloWorldLengthLong:Long = helloWorldLength.toLong()

    val string:String = "HelloWorld"
    val fromChars:String = String(charArrayOf('H','e','l','l','o','W','o','r','l','d'))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        println("zhua" + aChar)
        println("zhua" + bChar)
        println("zhua" + cChar)

        println("final hello world:" + FIANL_HELLOW_WORLD)
        println("assignable hello world:" + helloworld)
        println("hello world from nullable type:" + nullableHelloWorld)
        println("hello world from Array type:" + helloworldArray.joinToString(""))
        println("hello world from CharArray type:" + String(helloworldCharArray))
        println("class name hello world:" + DataType::class.java.simpleName)
        println("class name hello world:" + DataType::class.java.name)
        println("part of the class name of MainActivity:" + DataType::class.java.simpleName.slice(0 until 4))
        println("the length of hello world is:" + helloWorldLength)
        println("the length of hello world is(long):" + helloWorldLengthLong)
        println("string:" + string)
        println("fromChars:" + fromChars)

        println(string == fromChars)//相当于equals
        println(string === fromChars)//相当于java的等于，比较的引用值

        val arg1:Int = 1
        val arg2:Int = 2
        println("" + arg1 + "+" + arg2 + "=" + (arg1 + arg2))
        println("$arg1 + $arg2 = ${arg1 + arg2}")

        //hello "Trump"
        val sayHello:String = "Hello \"Trump\""
        println(sayHello)

        //salary
        val salary:Int = 1000
        println("\$$salary")
        println("$salary")

        val rawString :String = """//原始串，，$ 转义没法使用，只能加空格
        \t
        \n
        \\\\\\$$$ salary
        """
        println(rawString)
        println(rawString.length)

        /*Range*/
        val range:IntRange = 0..1024////[0,1024]
        val range_exclusive:IntRange = 0 until 1024////[0,1024)
        val emptyRange:IntRange = 0..-1

        println(emptyRange.isEmpty())
        println(range.contains(50))
        println(50 in range)

        for(i in range){
            println("$i, ")
        }

        //Array
        val arrayofInt:IntArray = intArrayOf(1,3,5,7)
        val arrayofChar:CharArray = charArrayOf('h','e','l','l','o')
        val arrayOfString:Array<String> = arrayOf("我","是","工","程","师")

        println(arrayofInt.size)
        for(i in arrayofInt){
            println(i)
        }

        println(String(arrayofChar))
        println(arrayOfString.slice(1..2))

        //null safe
        println(getName())
        val name:String? = getName()
        println(name!!.length)

        /*Type Cast*/
        val parent:Parent = Parent()
        val child:Child? = parent as? Child

        if(null != child){
            println(child.getName())
        }else{
            println(child)
        }

        val 妹子:meizi = meizi("温柔","甜美","动人")
        val 帅哥:shuaige = shuaige("彪悍","帅气","浑厚")

        println(妹子 is ren)
        println(帅哥 is ren)

    }

    class meizi (xingge:String,zhangxiang:String,shengyin:String):ren(xingge,zhangxiang,shengyin)
    class shuaige(xingge:String,zhangxiang: String,shengyin: String):ren(xingge,zhangxiang,shengyin)

    open class ren(var xingge:String,var zhangxiang:String,var shengyin:String){
        init {
            println("new 了一个${this.javaClass.simpleName},她性格:$xingge,长相：$zhangxiang,声音：$shengyin")
        }
    }

    fun getName():String?{
        return "zhua"
    }
}
