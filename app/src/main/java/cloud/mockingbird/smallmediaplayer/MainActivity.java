package cloud.mockingbird.smallmediaplayer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.la_traviata);

    Button playButton = (Button) findViewById(R.id.play_button);
    Button pauseButton = (Button) findViewById(R.id.pause_button);

    playButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
          @Override
          public void onCompletion(MediaPlayer mediaPlayer) {
            Toast.makeText(MainActivity.this, "Done!", Toast.LENGTH_SHORT).show();
          }
        });
      }
    });

    pauseButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        mediaPlayer.pause();
      }
    });

    TextView volumeLabel = (TextView) findViewById(R.id.tv_volume_label);
    SeekBar seekBar = (SeekBar) findViewById(R.id.sb_volume_control);

    seekBar.setProgress(31);

    seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });



  }
}
