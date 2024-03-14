//
//  AboutScreen.swift
//  iosApp
//
//  Created by Chyngyz on 12/3/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack{
            AboutListView()
                .navigationTitle("About Device")
        }
    }
}

struct AboutScreen_Previews: PreviewProvider {
    static var previews: some View {
        AboutScreen()
    }
}
