import SwiftUI
import shared

struct ContentView: View {
    
    @State private var shouldOpenAbout = false

	var body: some View {
        let articleScreen = ArticlesScreen(viewModel: .init())
        
        NavigationStack{
            articleScreen
                .toolbar{
                    ToolbarItem {
                        Button{
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle").labelStyle(.iconOnly)
                        }
                        .popover(isPresented: $shouldOpenAbout){
                            AboutScreen()
                        }
                    }
                }
        }.refreshable {
            articleScreen.viewModel.articlesViewModel.getArticles(isForceRefresh: true)
        }
	}
}

//struct ContentView_Previews: PreviewProvider {
//	static var previews: some View {
//		ContentView()
//	}
//}
