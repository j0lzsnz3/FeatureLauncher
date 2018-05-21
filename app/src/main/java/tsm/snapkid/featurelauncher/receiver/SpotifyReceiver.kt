package tsm.snapkid.featurelauncher.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SpotifyReceiver : BroadcastReceiver() {

    private val TAG = "SpotifyReceiver"

    internal object BroadcastTypes {
        val SPOTIFY_PACKAGE = "com.spotify.music"
        val PLAYBACK_STATE_CHANGED = SPOTIFY_PACKAGE + ".playbackstatechanged"
        val QUEUE_CHANGED = SPOTIFY_PACKAGE + ".queuechanged"
        val METADATA_CHANGED = SPOTIFY_PACKAGE + ".metadatachanged"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        // This is sent with all broadcasts, regardless of type. The value is taken from
        // System.currentTimeMillis(), which you can compare to in order to determine how
        // old the event is.
        val timeSentInMs = intent?.getLongExtra("timeSent", 0L)
        val action = intent?.action
        when (action) {
            BroadcastTypes.METADATA_CHANGED -> {
                val trackId = intent.getStringExtra("id")
                val artistName = intent.getStringExtra("artist")
                val albumName = intent.getStringExtra("album")
                val trackName = intent.getStringExtra("track")
                val trackLengthInSec = intent.getIntExtra("length", 0)

                Log.d(TAG, "trackId: $trackId \n artistName: $artistName \n albumName: $albumName \n trackName: $trackName \n trackLengthInSec: $trackLengthInSec")
            }
            BroadcastTypes.PLAYBACK_STATE_CHANGED -> {
                val playing = intent.getBooleanExtra("playing", false)
                val positionInMs = intent.getIntExtra("playbackPosition", 0)

                Log.d(TAG, "playing: $playing \n positionInMs: $positionInMs")
            }
            BroadcastTypes.QUEUE_CHANGED -> {
                Log.d(TAG, "QUEUE_CHANGED")
            }
        }
    }
}
