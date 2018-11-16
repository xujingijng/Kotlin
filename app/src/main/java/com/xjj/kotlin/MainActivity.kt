package com.xjj.kotlin

/**
 * 不用findviewbyId了，直接使用
 */
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.widget.Button
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Kotlin 的使用
 */
class MainActivity : FragmentActivity(){

    /*** 定义变量*/
    var i:Int = 1
    /*** 定义final变量*/
    private val j:Int = 2
    companion object {
        /*** 定义static final变量*/
        const val k:Int = 3
        /*** 定义static方法*/
        fun newInstance(int: Int,string: String): String {
            val ss:String= string
            return ss
        }
    }
    /*** 类型转换*/
    var a:Double = i.toDouble()
    /*** 三目运算符*/
    var b:Int = if (3 > 2) 3 else 2
    /*** 函数的变长参数可以用 vararg 关键字进行标识*/
    fun vars(vararg v:Int){
        for(vt in v){
            print(vt)
        }
    }
    /*** lamdba匿名函数表达式*/
    val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
    /*** $ 表示一个变量名或者变量*/
    val c = "s is $i"

    /***  类型后面加?表示可为空*/
    var age: String? = "23"
    /*** 抛出空指针异常*/
    val ages = age!!.toInt()
    /*** 不做处理返回 null*/
    val ages1 = age?.toInt()
    /*** age为空返回-1*/
    val ages2 = age?.toInt() ?: -1

    private var btn2:Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
        btn2 = this.findViewById(R.id.btn2)
        //两种接口调用方法
        val a = A()
        a.setOnListen(object : A.OnClickListen{
            override fun click(s: String) {
                Log.i("java方法：",s)
            }
        })
        a.setListeren {
            //只有一个参数时，it 代表传入的参数
            Log.i("Lambda方法：",it)
        }

        a.setCC {
            sucess {
                //有多个接口方法
                Log.i("Lambda方法，多个接口：",it)
            }
            fail {
                //有多个接口
                Log.i("Lambda方法，多个接口：",""+it)
            }
        }

        a.setMM { s, i ->
            //有多个参数
            Log.i("Lambda方法，多个参数：",s+""+i)
        }

        var ss = a.callback(1,2) {
            a,b -> a+b
        }
        println("Lambda方法，两个参数相加：$ss")

    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}
