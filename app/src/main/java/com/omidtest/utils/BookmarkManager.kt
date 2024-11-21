import android.content.Context
import android.content.SharedPreferences

object BookmarkManager {
    private const val PREF_NAME = "bookmarks_pref"
    private const val KEY_BOOKMARKS = "bookmarked_items"

    fun isBookmarked(context: Context, productId: String): Boolean {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val bookmarkedItems = preferences.getStringSet(KEY_BOOKMARKS, emptySet())
        return bookmarkedItems?.contains(productId) == true
    }

    fun toggleBookmark(context: Context, productId: String) {
        val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val bookmarkedItems = preferences.getStringSet(KEY_BOOKMARKS, mutableSetOf()) ?: mutableSetOf()

        if (bookmarkedItems.contains(productId)) {
            bookmarkedItems.remove(productId)
        } else {
            bookmarkedItems.add(productId)
        }

        preferences.edit().putStringSet(KEY_BOOKMARKS, bookmarkedItems).apply()
    }
}
