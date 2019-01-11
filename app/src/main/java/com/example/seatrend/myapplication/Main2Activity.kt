package com.example.seatrend.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.seatrend.myapplication.JavaTest.MyDiffUtils
import com.example.seatrend.myapplication.kotlin.RecyclerAdapter
import com.example.seatrend.myapplication.kotlin.presenter.TestPresenter
import com.example.seatrend.myapplication.kotlin.test2
import com.example.seatrend.myapplication.kotlin.view.TestView
import kotlinx.android.synthetic.main.activity_main2.*
import java.nio.file.Files.find

class Main2Activity : AppCompatActivity() ,TestView{


    override fun success(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    var mTestPresenter=TestPresenter(this)


    val tee=3;

    val TAG:String="got it";

  var array=IntArray(10); //声明长度为10的int类的数组
  var array2= intArrayOf(1,1,1,1,1,11,1,1);
    var  array3= arrayOfNulls<String>(10)


    var arrar4= floatArrayOf(2.56f,2.34f)
    var arrar5= doubleArrayOf(2.366,248.6563,96.315)
    var lis=ArrayList<String>();

    var oldData=ArrayList<String>()
    var newData=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val ini= init()
        testMethod();

        for (i in 0..10){
            oldData.add("old"+i)
        }


        initRecyclerView();
    }

    private fun initRecyclerView() {
        val mRecyclerView = findViewById<RecyclerView>(R.id.m_recycler_view)
        mRecyclerView.layoutManager=LinearLayoutManager(this)
                //mRecyclerView.adapter=

        m_recycler_view.adapter=RecyclerAdapter(this,oldData)

       /*var DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiffUtils(), true);
        diffResult.dispatchUpdatesTo(adpter);*/



        val mDiffUtils=MyDiffUtils(oldData,newData)
        val diffResult = DiffUtil.calculateDiff(mDiffUtils)
        diffResult.dispatchUpdatesTo(m_recycler_view.adapter)
    }

    private fun testMethod() {
        btn_testmvp.setOnClickListener {
            mTestPresenter.getMessage(666)
        }



    }


    fun init():String?{
        btn_test.text="button_new";
        val button = findViewById<Button>(R.id.btn_test);
       // btn_test2.text=getString(0)

        val  pp=btn_test2.text
        button.setOnClickListener(View.OnClickListener {
           // Toast.makeText(this,"OnClickListener",Toast.LENGTH_SHORT).show()

            val test2 = test2(1, "1", 1)
            val getmessage = test2.getmessage()

            Toast.makeText(this,getmessage,Toast.LENGTH_SHORT).show()
        })

        btn_test2.setOnClickListener {

        }

     /*   when(tee){
            1->""
           in 2..5->""

            in 8..12->""
            else->""


        }

        for (lis in 1..5){

        }

        for (string in lis){

        }
        lis.forEach {

        }*/

      return "ppppp";

    }
}
