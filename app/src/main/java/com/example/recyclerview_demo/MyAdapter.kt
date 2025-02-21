package com.example.recyclerview_demo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ToggleButton
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_demo.databinding.ItemLayoutBinding

class MyAdapter(private val itemList:MutableList<ModelClass>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(item:ModelClass){
            binding.textView.text = item.feature
            binding.toggleButton.isChecked = item.isToggled

            binding.toggleButton.setOnCheckedChangeListener { _,isChecked ->
                item.isToggled = isChecked
            }

            binding.itemLayout.setOnLongClickListener {
                showDeleteDialog(adapterPosition,binding)
                true
            }

            binding.itemLayout.setOnClickListener {
                showUpdateDialog(adapterPosition,binding)
            }
        }
    }

    private fun showUpdateDialog(adapterPosition: Int, binding: ItemLayoutBinding) {
        val context = binding.root.context
        val item = itemList[adapterPosition]

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_update, null)
        val editText = dialogView.findViewById<EditText>(R.id.editTextUpdate)
        val toggleButton = dialogView.findViewById<ToggleButton>(R.id.toggleUpdate)

        editText.setText(item.feature)
        toggleButton.isChecked = item.isToggled

        val dialog = AlertDialog.Builder(context)
            .setTitle("Update Item")
            .setView(dialogView)
            .setPositiveButton("Update") { _, _ ->
                val updatedText = editText.text.toString()
                val updatedToggle = toggleButton.isChecked

                itemList[adapterPosition] = ModelClass(updatedText, updatedToggle)

                notifyItemChanged(adapterPosition)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss() // Close dialog without updating
            }
            .create()

        dialog.show()
    }


    private fun showDeleteDialog(position: Int, binding: ItemLayoutBinding) {
        val context = binding.root.context  // Get context from any view
        val builder = androidx.appcompat.app.AlertDialog.Builder(context)

        builder.setTitle("Delete Item")
            .setMessage("Are you sure you want to delete this item?")
            .setPositiveButton("Yes") { _, _ ->
                removeItem(position)
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .show()

    }

    fun removeItem(position: Int) {
        if (position >= 0 && position < itemList.size) {
            itemList.removeAt(position)
            notifyItemRemoved(position)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }
}