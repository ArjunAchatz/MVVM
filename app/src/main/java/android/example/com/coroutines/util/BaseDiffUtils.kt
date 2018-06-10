package android.example.com.coroutines.util

import android.support.v7.util.DiffUtil

abstract class BaseDiffUtils<T>(val oldList: List<T>, val newList: List<T>) : DiffUtil.Callback() {

    abstract fun areIdsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areIdsTheSame(oldItemPosition, newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}