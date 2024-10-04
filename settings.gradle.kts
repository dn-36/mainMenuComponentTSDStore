rootProject.name = "MainMenuComponentTSDStore"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":features:chat")
include(":features:crm")
include(":features:home")
include(":features:profile")
include(":features:tape")
include(":core")
include(":common")

/**application-sections**/
include(":features:application-sections")
/**chat-section**/
/*--*/include(":features:application-sections:chat-section")
/*--*/include(":features:application-sections:chat-section:chats-api")
/**crm-section**/
/*--*/include(":features:application-sections:crm-section")

/** features**/
/*----*/include(":features:application-sections:crm-section:create-notes-feature")
/** api and impl**/
/*------*/include(":features:application-sections:crm-section:create-notes-feature:create-notes-impl")
/*------*/include(":features:application-sections:crm-section:create-notes-feature:create-notes-api")

/**features**/
/*----*/include(":features:application-sections:crm-section:edit-note-feature")
/** api and impl**/
/*------*/include(":features:application-sections:crm-section:edit-note-feature:edit-note-impl")
/*------*/include(":features:application-sections:crm-section:edit-note-feature:edit-note-api")

/**features**/
/*----*/include(":features:application-sections:crm-section:notes-feature")
/** api and impl**/
/*------*/include(":features:application-sections:crm-section:notes-feature:notes-impl")
/*------*/include(":features:application-sections:crm-section:notes-feature:notes-api")

/**features**/
/*----*/include(":features:application-sections:crm-section:munu-feature")
/** api and impl**/
/*------*/include(":features:application-sections:crm-section:munu-feature:munu-api")
/*------*/include(":features:application-sections:crm-section:munu-feature:menu-impl")


/**features**/
/*----*/include(":features:application-sections:crm-section:project-conterol-feature")
/** api and impl **/
/*------*/include(":features:application-sections:crm-section:project-conterol-feature:project_control-impl")
/*------*/include(":features:application-sections:crm-section:project-conterol-feature:project-control-api")

/**chat**/

/*--*/include(":features:application-sections:home-section")
/*--*/include(":features:application-sections:tape-section")
/*--*/include(":")


include(":features:navigation")
include(":features:application-sections:home-section:home-impl")
