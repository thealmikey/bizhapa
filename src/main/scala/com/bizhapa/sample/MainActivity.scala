package com.bizhapa.sample

import java.util

import android.app.Activity
import android.arch.lifecycle._
import android.arch.persistence.room.Room
import android.os.Bundle
import android.view.{LayoutInflater, View, ViewGroup}
import android.widget.{Button, EditText, TextView}
import android.support.v7.widget.{LinearLayoutManager, RecyclerView}
import java.util.List

class MainActivity extends Activity with LifecycleRegistryOwner {

  var theRecyclerView: RecyclerView = _
  var recyclerViewAdapter: RecyclerView.Adapter[_ <: RecyclerView.ViewHolder] = _
  var theEditBox: EditText = _
  var theButton: Button = _


  import android.arch.lifecycle.LifecycleRegistry

    val lifecycleRegistry = new LifecycleRegistry(this)
    def getLifecycle: LifecycleRegistry = lifecycleRegistry

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    this.setContentView(R.layout.the_main)

     lazy val db:AppDatabase = Room.databaseBuilder(getApplicationContext, classOf[AppDatabase], "onetext_db").build()

      theRecyclerView = findViewById(R.id.theList).asInstanceOf[RecyclerView]
      theEditBox = findViewById(R.id.myEditBox).asInstanceOf[EditText]
      theButton = findViewById(R.id.myAddButton).asInstanceOf[Button]

      theRecyclerView.setLayoutManager(new LinearLayoutManager(this))
    var emptyL = Array[OnetextModel]()
      recyclerViewAdapter = new MyAdapter(emptyL)
      theRecyclerView.setAdapter(recyclerViewAdapter)

      var myViewModel = new OnetextListViewModel(this.getApplication, db)
      myViewModel.getOneTextList.observe(this, new Observer[Array[OnetextModel]] {
        override def onChanged(t: Array[OnetextModel]): Unit = {
          var otherAdapter = new MyAdapter(t)
          theRecyclerView.setAdapter(otherAdapter)
          theRecyclerView.getAdapter.notifyDataSetChanged()
        }
      })

      theButton.setOnClickListener(new View.OnClickListener {
        override def onClick(v: View): Unit = {
          var theTexty = theEditBox.getText.toString
          var aModel =new OnetextModel(theTexty)
          new Thread(new Runnable {
            override def run(): Unit = {
              db.theTextModel().addText(aModel)
            }
          }).start()

        }
      })


    }

    class MyViewHolder(view: View) extends RecyclerView.ViewHolder(view) {
      var theTextView = view.findViewById(R.id.oneText).asInstanceOf[TextView]
    }

    class MyAdapter(var oneTextList:Array[OnetextModel]) extends RecyclerView.Adapter[MyViewHolder] {


      override def getItemCount: Int = oneTextList.size

      override def onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder = {
        new MyViewHolder(LayoutInflater.from(viewGroup.getContext).inflate(R.layout.one_item, viewGroup, false))
      }

      override def onBindViewHolder(holder: MyViewHolder, position: Int): Unit = {
        var oneItemModel = oneTextList(position)
        holder.theTextView.setText(oneItemModel.theText)
      }

      def addItems(oneTextList: Array[OnetextModel]) = {
        this.oneTextList = oneTextList
        notifyDataSetChanged()
      }
    }



}