package mostafa.projects.customviews.Utils

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.util.Base64
import android.util.Log
import androidx.core.content.FileProvider
import java.io.ByteArrayOutputStream
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object ImageManger {
    private const val CAPTURE_IMAGE_FILE_PROVIDER = "com.appssquare"
    private var IMAGE_NMAE = ""
    fun getBase64Bitmap(inImage: Bitmap): String { //convert bitmap to base64
        val baos = ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val b = baos.toByteArray()
        val imageEncoded = Base64.encodeToString(b, Base64.NO_WRAP)
        Log.e("LOOK", imageEncoded)
        return imageEncoded
    }

    fun save_image_in_provider(context: Context): Uri { //to get full image not pixeled
        val imagePath = File(context.filesDir, "images")
        if (!imagePath.exists()) imagePath.mkdirs()
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val image = File(imagePath, "$timeStamp.jpg")
        IMAGE_NMAE = "$timeStamp.jpg"
        return FileProvider.getUriForFile(context, CAPTURE_IMAGE_FILE_PROVIDER, image)
    }

    fun get_saved_image(context: Context): File {
        val path = File(context.filesDir, "images")
        if (!path.exists()) path.mkdirs()
        return File(path, IMAGE_NMAE)
    }

    fun Delete_Images(context: Context) { //delet all files
        val path = File(context.filesDir, "images")
        if (!path.exists()) path.mkdirs()
        for (i in path.listFiles().indices) {
            val file = path.listFiles()[i]
            file.delete()
        }
    }

    fun Delete_Image(context: Context) { //delet all files
        val path = File(context.filesDir, "images")
        val imageFile = File(path, IMAGE_NMAE)
        imageFile.delete()
    }
}