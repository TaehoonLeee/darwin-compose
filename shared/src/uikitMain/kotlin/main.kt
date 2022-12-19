import androidx.compose.ui.main.defaultUIKitMain
import androidx.compose.ui.window.Application
import com.example.darwincompose.ui.MainContent
import kotlinx.cinterop.*
import platform.Foundation.NSStringFromClass
import platform.UIKit.*

fun main() {
	defaultUIKitMain("DarwinCompose", Application("DarwinCompose") {
		MainContent()
	})
}

fun viewController() = Application {
	MainContent()
}