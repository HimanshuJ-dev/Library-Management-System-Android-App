package com.example.etpproject

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toBitmap
import androidx.room.Room
import com.example.etpproject.bookdatabasepackage.Books
import com.example.etpproject.bookdatabasepackage.BooksDatabase
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity() {

    lateinit var database: BooksDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(this, BooksDatabase::class.java, "books_database").allowMainThreadQueries().build()

        addToBooksDb()
    }

    fun imgconvrt(drawable: Drawable): ByteArray{
        val bitmap = (drawable as BitmapDrawable).getBitmap()
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
        val image = stream.toByteArray()
        return image
    }

    private fun addToBooksDb(){

        val featured = "Featured"
        val topSelling = "Top Selling"
        val amazing = "Amazing Reads"
        val recommended = "Recommended"
        val none = "None"

        val fiction = "Fiction and Literature"
        val comics = "Comics"
        val health = "Health, Mind and Body"
        val romance = "Romance"
        val selfHelp = "Self-Help"
        val history = "History"
        val arts = "Arts and Entertainment"
        val cookery = "Cookery, Food and Wine"

        val hp1i = getDrawable(R.drawable.hp1)
        val hp1img = hp1i?.let { imgconvrt(it) }

        var books = Books(0, "Harry Potter and the Philosopher's Stone", "J. K. Rowling", fiction,
            300, 4.9f, "Bloomsbury", "First Book in Harry Potter series", hp1img, featured)
        database.booksDao().addBook(books)

        val hp2i = getDrawable(R.drawable.hp2)
        val hp2img = hp2i?.let { imgconvrt(it) }
        books = Books(1, "Harry Potter and the Chamber of Secrets","J. K. Rowling", fiction,
            350, 4.7f, "Bloomsbury", "Second Book in Harry Potter series", hp2img, amazing)
        database.booksDao().addBook(books)

        val hp3i = getDrawable(R.drawable.hp3)
        val hp3img = hp3i?.let { imgconvrt(it) }
        books = Books(2, "Harry Potter and the Prisoner of Azkaban","J. K. Rowling", fiction,
            330, 4.8f, "Bloomsbury", "Third Book in Harry Potter series", hp3img, none)
        database.booksDao().addBook(books)

        val hp4i = getDrawable(R.drawable.hp4)
        val hp4img = hp4i?.let { imgconvrt(it) }
        books = Books(3, "Harry Potter and the Goblet of Fire","J. K. Rowling", fiction,
            650, 4.3f, "Bloomsbury", "Fourth Book in Harry Potter series", hp4img, none)
        database.booksDao().addBook(books)

        val hp5i = getDrawable(R.drawable.hp5)
        val hp5img = hp5i?.let { imgconvrt(it) }
        books = Books(4, "Harry Potter and the Order of the Phoenix","J. K. Rowling", fiction,
            730, 4.6f, "Bloomsbury", "Fifth Book in Harry Potter series", hp5img, amazing)
        database.booksDao().addBook(books)

        val hp6i = getDrawable(R.drawable.hp6)
        val hp6img = hp6i?.let { imgconvrt(it) }
        books = Books(5, "Harry Potter and the Half-Blood Prince","J. K. Rowling", fiction,
            620, 4.1f, "Bloomsbury", "Sixth Book in Harry Potter series", hp6img, recommended)
        database.booksDao().addBook(books)

        val hp7i = getDrawable(R.drawable.hp7)
        val hp7img = hp7i?.let { imgconvrt(it) }
        books = Books(6, "Harry Potter and the Deathly Hallows","J. K. Rowling", fiction,
            680, 4.8f, "Bloomsbury", "Final Book in Harry Potter series", hp7img, topSelling)
        database.booksDao().addBook(books)

        val dkd = getDrawable(R.drawable.dkd)
        val dkdimg = dkd?.let { imgconvrt(it) }
        books = Books(7, "Deadpool Kills Deadpool","Cullen Bunn", comics,
            96, 3.9f, "Marvel Entertainment", "The final act of the Deadpool Killogy begins!", dkdimg, amazing)
        database.booksDao().addBook(books)

        val subm = getDrawable(R.drawable.submind)
        val submimg = subm?.let { imgconvrt(it) }
        books = Books(8, "The Power of Your Subconscious Mind","Joseph Murphy", health,
            280, 4.3f, "General Press", "Dr Joseph Murphy explains that life events are actually the result of the workings of your conscious and subconscious mind.", submimg, recommended)
        database.booksDao().addBook(books)

        val lw = getDrawable(R.drawable.loveway)
        val lwimg = lw?.let { imgconvrt(it) }
        books = Books(9, "Love Will Find a Way","Anurag Garg", romance,
            232, 3.8f, "Penguin Random House", "A story about Madhav and his love life", lwimg, featured)
        database.booksDao().addBook(books)

        val invip = getDrawable(R.drawable.invisiblepower)
        val invipimg = invip?.let { imgconvrt(it) }
        books = Books(10, "Your Invisible Power","Genevieve behrend", selfHelp,
            160, 3.5f, "General Press", "Genevieve Behrend will guide you through the use of visualization", invipimg, topSelling)
        database.booksDao().addBook(books)

        val aow = getDrawable(R.drawable.artwar)
        val aowimg = aow?.let { imgconvrt(it) }
        books = Books(11, "The Art of War","Sun Tzu", history,
            128, 4.1f, "General Press", "The art of war is a translation of Sun Tzu's originally written book on battle strategies by author James Clavell", aowimg, recommended)
        database.booksDao().addBook(books)

        val tdd = getDrawable(R.drawable.devilsd)
        val tddimg = tdd?.let { imgconvrt(it) }
        books = Books(12, "The Devil's Double","Latif Yahia", arts,
            330, 3.8f, "Arcanum Media Group", "Latif Yahia was taken to Saddam's headquaters to meet Uday...", tddimg, featured)
        database.booksDao().addBook(books)

        val kc = getDrawable(R.drawable.kasmiric)
        val kcimg = kc?.let { imgconvrt(it) }
        books = Books(13, "Kashmiri Cooking","P Krishna Dar", cookery,
            208, 4.7f, "Penguin UK", "Krishna Prasad Dar's collection of over a hundred Kashmiri recipes became a classic in its time.", kcimg, amazing)
        database.booksDao().addBook(books)
    }

}