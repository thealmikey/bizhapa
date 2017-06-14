package com.bizhapa.sample

import android.app.Activity
import android.arch.lifecycle._
import android.os.Bundle
import android.view.{LayoutInflater, View, ViewGroup}
import android.widget.{Button, EditText, TextView}
import com.bizhapa.sample.OnetextListViewModel.addTextAsync
import android.support.v7.widget.{LinearLayoutManager, RecyclerView}


class MainActivity extends Activity with LifecycleRegistryOwner {

  var theRecyclerView:RecyclerView = _
  var recyclerViewAdapter:RecyclerView.Adapter[_<: RecyclerView.ViewHolder] = _
  var theEditBox:EditText = _
  var theButton:Button = _

  import android.arch.lifecycle.LifecycleRegistry

  import android.arch.lifecycle.LifecycleRegistry

  val lifecycleRegistry = new LifecycleRegistry(this)
  def getLifecycle: LifecycleRegistry = lifecycleRegistry

  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    this.setContentView(R.layout.the_main)


    theRecyclerView = findViewById(R.id.theList).asInstanceOf[RecyclerView]
    theEditBox = findViewById(R.id.myEditBox).asInstanceOf[EditText]
    theButton = findViewById(R.id.myAddButton).asInstanceOf[Button]

    theRecyclerView.setLayoutManager(new LinearLayoutManager(this))
    recyclerViewAdapter = new MyAdapter(List.empty[OnetextModel])
    theRecyclerView.setAdapter(recyclerViewAdapter)

    var myViewModel = new OnetextListViewModel(this.getApplication)
    myViewModel.getOneTextList.observe(this, new Observer[List[OnetextModel]]{
      override def onChanged(t: List[OnetextModel]): Unit = {
        var otherAdapter = new MyAdapter(t)
        theRecyclerView.setAdapter(otherAdapter)
        theRecyclerView.getAdapter.notifyDataSetChanged()
      }
    })

    theButton.setOnClickListener(new View.OnClickListener {
      override def onClick(v: View): Unit = {
        var theTexty = theEditBox.getText.toString
        var aModel = new OnetextModel
        aModel.theText = theTexty
       new addTextAsync(AppDatabase.getDatabase(MainActivity.this.getApplicationContext)).execute(aModel)
      }
    })


  }

  class MyViewHolder(view:View) extends RecyclerView.ViewHolder(view){
    var theTextView = view.findViewById(R.id.oneText).asInstanceOf[TextView]
  }

  class MyAdapter(var oneTextList:List[OnetextModel]) extends RecyclerView.Adapter[MyViewHolder]{

    override def getItemCount: Int = oneTextList.size

    override def onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder = {
      new MyViewHolder(LayoutInflater.from(viewGroup.getContext).inflate(R.layout.one_item, viewGroup, false))
    }

    override def onBindViewHolder(holder: MyViewHolder, position: Int): Unit = {
      var oneItemModel = oneTextList(position)
      holder.theTextView.setText(oneItemModel.theText)
    }

    def addItems(oneTextList:List[OnetextModel])={
      this.oneTextList = oneTextList
      notifyDataSetChanged()
    }
  }


}
