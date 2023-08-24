package ecb.manifest.kowalki.avaliacaoteste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import ecb.manifest.kowalki.avaliacaoteste.databinding.ActivityMainBinding
import org.osmdroid.views.MapView
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var map:MapView
    private val REQUEST_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO Permissoes
        binding = ActivityMainBinding.inflate(layoutInflater)
        Configuration.getInstance().load(this,getSharedPreferences("osmdroid",0))
        setContentView(binding.root)
        map = binding.map
        map.setTileSource(TileSourceFactory.MAPNIK)
        val mapController = map.controller
        map.controller.setZoom(17)
        val startPoint = GeoPoint(-23.57396958491518, -46.62320156325983)
        mapController.setCenter(startPoint)
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}