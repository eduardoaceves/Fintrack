import SwiftUI
import Shared

@main
struct iOSApp: App {

    init() {
        KoinIOSKt.doInitKoinIOS()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
