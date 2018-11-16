package com.xjj.kotlin

/**
 *  Describe: 接口回掉
 *  @author xujingjing
 *  @date  2018/7/16 0016
 */
class A {
    /**
     * 用java写法
     */
    lateinit var onclick: OnClickListen
    fun setOnListen(onClickListen: OnClickListen){
        this.onclick = onClickListen
        this.onclick?.click("name")
    }

    interface OnClickListen {
        fun click(s : String)
    }

    /**
     * 用Lambda写法
     * 函数 ： 一个单方法的接口(只有一个参数)
     */
    lateinit var mListen: (String) -> Unit // (String) -> Unit是一个整体不可分割，（String）可以是任何类型的参数
    fun setListeren(listener: (String) -> Unit){
        this.mListen = listener
        this.mListen("invoke :") //等于 mListen?.invoke("invoke :" +name)  X()等同于X.invoke()
    }

    /**
     * 用Lambda写法
     * 函数 ： 一个单方法的接口（有多个参数）
     */
    lateinit var mm: (s:String,i:Int) -> Unit
    fun setMM(listener: (s:String,i:Int) -> Unit){
        this.mm = listener
        this.mm("name",1)

        //调用多个接口方法
       // sa?.sucess?.invoke("sdfsdfds")
    }

    /**
     * 用Lambda写法
     * 函数 ： 多个方法的接口
     */
        var sa: A ? = null
        var sucess: ((s:String) -> Unit)? = null
        var fail: ((i:Int) -> Unit)? = null

        fun sucess(listener: (s: String) -> Unit){
            sucess = listener
        }
        fun fail(listener: (i: Int) -> Unit){
            fail = listener
        }

        fun setCC(xx: A.() -> Unit){
            sa = A()
            sa?.xx()
        }

    /**
     * 返回值
     */
    fun callback(a: Int,b: Int,callback: (c:Int,b:Int) -> Int): Int {
        return callback.invoke(a,b)
    }


}

fun main(args: Array<String>) {
    var a = A()
    var ss = a.callback(1,2) {
        a,b -> a+b
    }
    println("Lambda方法，两个参数相加：$ss")

}