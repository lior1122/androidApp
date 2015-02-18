package utils;

import java.lang.ref.WeakReference;

import com.example.project.R;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageDownloaderTask extends AsyncTask<String, Void, Bitmap> {
	private final WeakReference imageViewReference;

	public ImageDownloaderTask(ImageView imageView) {
		imageViewReference = new WeakReference(imageView);
	}

	@Override
	// Actual download method, run in the task thread
	protected Bitmap doInBackground(String... params) {
		// params comes from the execute() call: params[0] is the url.
		return Utils.DownloadBitmap(params[0]);
	}

	@Override
	// Once the image is downloaded, associates it to the imageView
	protected void onPostExecute(Bitmap bitmap) {
		if (isCancelled()) {
			bitmap = null;
		}

		if (imageViewReference != null) {
			ImageView imageView = (ImageView) imageViewReference.get();
			if (imageView != null) {

				if (bitmap != null) {
					imageView.setImageBitmap(bitmap);
				} else {
					imageView.setImageDrawable(imageView.getContext().getResources()
							.getDrawable(R.drawable.icon));
				}
			}

		}
	}

}