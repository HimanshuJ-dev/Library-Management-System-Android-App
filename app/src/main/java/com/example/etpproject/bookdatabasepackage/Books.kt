package com.example.etpproject.bookdatabasepackage

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.sql.Blob

@Entity(tableName = "books")
data class Books(
    @PrimaryKey(autoGenerate = true)
    val bookid: Int?,
    val BookName: String?,
    val WriterName: String?,
    val BookGenre: String?,
    val BookPagesCount: Int?,
    val BookRating: Float?,
    val BookPublisher: String?,
    val BookAbout: String?,
    val BookImage: ByteArray?,
    val BookCategory: String?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Books

        if (bookid != other.bookid) return false
        if (BookName != other.BookName) return false
        if (WriterName != other.WriterName) return false
        if (BookGenre != other.BookGenre) return false
        if (BookPagesCount != other.BookPagesCount) return false
        if (BookRating != other.BookRating) return false
        if (BookPublisher != other.BookPublisher) return false
        if (BookAbout != other.BookAbout) return false
        if (BookImage != null) {
            if (other.BookImage == null) return false
            if (!BookImage.contentEquals(other.BookImage)) return false
        } else if (other.BookImage != null) return false
        if (BookCategory != other.BookCategory) return false

        return true
    }

    override fun hashCode(): Int {
        var result = bookid ?: 0
        result = 31 * result + (BookName?.hashCode() ?: 0)
        result = 31 * result + (WriterName?.hashCode() ?: 0)
        result = 31 * result + (BookGenre?.hashCode() ?: 0)
        result = 31 * result + (BookPagesCount ?: 0)
        result = 31 * result + (BookRating?.hashCode() ?: 0)
        result = 31 * result + (BookPublisher?.hashCode() ?: 0)
        result = 31 * result + (BookAbout?.hashCode() ?: 0)
        result = 31 * result + (BookImage?.contentHashCode() ?: 0)
        result = 31 * result + (BookCategory?.hashCode() ?: 0)
        return result
    }
}