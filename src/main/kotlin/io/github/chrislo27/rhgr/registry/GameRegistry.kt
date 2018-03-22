package io.github.chrislo27.rhgr.registry

import io.github.chrislo27.rhgr.registry.InputType.*
import io.github.chrislo27.rhgr.registry.Installment.*
import java.util.*


/**
 * The game registry. It holds a mapping of string keys to [Minigame]s.
 */
object GameRegistry {

    val backingMap: Map<String, Minigame> = mutableMapOf()

    init {
        addGames()
    }

    operator fun get(key: String): Minigame? {
        return backingMap[key]
    }

    operator fun contains(key: String): Boolean {
        return backingMap.containsKey(key)
    }

    operator fun contains(minigame: Minigame): Boolean {
        return backingMap.containsValue(minigame)
    }

    // Long
    private fun addGames() {
        backingMap as MutableMap
        
        fun Minigame.add() {
            backingMap[this.id] = this
        }

        Minigame("bonOdori", "Bon Odori, The☆", EnumSet.of(TENGOKU), EnumSet.of(CUE)).add()
        Minigame("bouncyRoad", "Bouncy Road", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(EQUIDISTANT)).add()
        Minigame("bunnyHop", "Bunny Hop", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(KEEP_THE_BEAT)).add()
        Minigame("clappyTrio", "Clappy Trio, The", EnumSet.of(TENGOKU, FEVER, MEGAMIX), EnumSet.of(EQUIDISTANT)).add()
        Minigame("fireworks", "Fireworks", EnumSet.of(TENGOKU), EnumSet.of(CUE)).add()
        Minigame("karateMan", "Karate Man Returns!", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("marchingOrders", "Marching Orders", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(KEEP_THE_BEAT, CUE)).add()
        Minigame("nightWalk", "Night Walk", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(KEEP_THE_BEAT)).add()
        Minigame("ninjaBodyguard", "Ninja Bodyguard", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(CALL_AND_RESPONSE)).add()
        Minigame("polyrhythm", "Polyrhythm", EnumSet.of(TENGOKU), EnumSet.of(CALL_AND_RESPONSE)).add()
        Minigame("powerCalligraphy", "Power Calligraphy", EnumSet.of(TENGOKU, FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("quizShow", "Quiz Show", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(CALL_AND_RESPONSE)).add()
        Minigame("rapMen", "Rap Men / Rap Women", EnumSet.of(TENGOKU), EnumSet.of(CUE)).add()
        Minigame("ratRace", "Rat Race", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("rhythmTweezers", "Rhythm Twezers", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(CALL_AND_RESPONSE)).add()
        Minigame("samuraiSliceGba", "Samurai Slice (GBA)", EnumSet.of(TENGOKU), EnumSet.of(CUE)).add()
        Minigame("showtime", "Showtime", EnumSet.of(TENGOKU), EnumSet.of(CUE)).add()
        Minigame("sickBeats", "Sick Beats", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("sneakySpirits", "Sneaky Spirits", EnumSet.of(TENGOKU, FEVER, MEGAMIX), EnumSet.of(EQUIDISTANT)).add()
        Minigame("spaceDance", "Space Dance", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("spaceball", "Spaceball", EnumSet.of(TENGOKU, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("tapTrial", "Tap Trial", EnumSet.of(TENGOKU, FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("tossBoys", "Toss Boys", EnumSet.of(TENGOKU), EnumSet.of(CUE)).add()
        Minigame("tramAndPauline", "Tram and Pauline", EnumSet.of(TENGOKU), EnumSet.of(CUE)).add()
        Minigame("wizardWaltz", "Wizard Waltz", EnumSet.of(TENGOKU), EnumSet.of(CALL_AND_RESPONSE)).add()

        Minigame("airboarder", "Airboarder", EnumSet.of(DS, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("bigRockFinish", "Big Rock Finish", EnumSet.of(DS, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("blueBirds", "Blue Birds", EnumSet.of(DS, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("builtToScaleDS", "Built to Scale (DS)", EnumSet.of(DS), EnumSet.of(EQUIDISTANT)).add()
        Minigame("cropStomp", "Crop Stomp", EnumSet.of(DS), EnumSet.of(KEEP_THE_BEAT)).add()
        Minigame("djSchool", "DJ School", EnumSet.of(DS), EnumSet.of(CUE)).add()
        Minigame("dogNinja", "Dog Ninja", EnumSet.of(DS, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("drummerDuel", "Drummer Duel", EnumSet.of(DS), EnumSet.of(CALL_AND_RESPONSE)).add()
        Minigame("fanClub", "Fan Club", EnumSet.of(DS, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("fillbots", "Fillbots", EnumSet.of(DS, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("freezeFrame", "Freeze Frame", EnumSet.of(DS, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("frogHop", "Frog Hop", EnumSet.of(DS, MEGAMIX), EnumSet.of(KEEP_THE_BEAT, CUE)).add()
        Minigame("gleeClub", "Glee Club", EnumSet.of(DS, MEGAMIX), EnumSet.of(EQUIDISTANT)).add()
        Minigame("karateManKicks", "Karate Man Kicks!", EnumSet.of(DS, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("lockstep", "Lockstep", EnumSet.of(DS, MEGAMIX), EnumSet.of(KEEP_THE_BEAT)).add()
        Minigame("loveLab", "Love Lab", EnumSet.of(DS), EnumSet.of(CALL_AND_RESPONSE)).add()
        Minigame("loveLizards", "Love Lizards", EnumSet.of(DS), EnumSet.of(CUE)).add()
        Minigame("moaiDooWop", "Moai Doo-Wop", EnumSet.of(DS), EnumSet.of(CALL_AND_RESPONSE)).add()
        Minigame("munchyMonk", "Munchy Monk", EnumSet.of(DS, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("rhythmRally", "Rhythm Rally", EnumSet.of(DS, MEGAMIX), EnumSet.of(KEEP_THE_BEAT)).add()
        Minigame("rockers", "Rockers", EnumSet.of(DS), EnumSet.of(CALL_AND_RESPONSE, CUE)).add()
        Minigame("shootEmUp", "Shoot-'em-up", EnumSet.of(DS, MEGAMIX), EnumSet.of(CALL_AND_RESPONSE)).add()
        Minigame("spaceSoccer", "Space Soccer", EnumSet.of(DS), EnumSet.of(KEEP_THE_BEAT, CUE)).add()
        Minigame("splashdown", "Splashdown", EnumSet.of(DS), EnumSet.of(EQUIDISTANT, CUE)).add()
        Minigame("theDazzles", "Dazzles, The", EnumSet.of(DS, MEGAMIX), EnumSet.of(CUE)).add()

        Minigame("airRally", "Air Rally", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(KEEP_THE_BEAT, CUE)).add()
        Minigame("boardMeeting", "Board Meeting", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(EQUIDISTANT, CUE)).add()
        Minigame("bossaNova", "Bossa Nova", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(KEEP_THE_BEAT)).add()
        Minigame("builtToScaleFever", "Built to Scale (Fever)", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("catchOfTheDay", "Catch of the Day", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("cheerReaders", "Cheer Readers", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("donkDonk", "Donk-Donk", EnumSet.of(FEVER), EnumSet.of(KEEP_THE_BEAT)).add()
        Minigame("doubleDate", "Double Date", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("exhibitionMatch", "Exhibition Match", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("figureFighter", "Figure Fighter", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("flipperFlop", "Flipper-Flop", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(KEEP_THE_BEAT, CUE)).add()
        Minigame("flockstep", "Flockstep", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(KEEP_THE_BEAT, CUE)).add()
        Minigame("forkLifter", "Fork Lifter", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("holeInOne", "Hole in One", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("karateManCombos", "Karate Man Combos!", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("launchParty", "Launch Party", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("loveRap", "Love Rap", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("microRow", "Micro-Row", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(KEEP_THE_BEAT)).add()
        Minigame("monkeyWatch", "Monkey Watch", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(KEEP_THE_BEAT)).add()
        Minigame("nightWalkFever", "Night Walk (Fever)", EnumSet.of(FEVER), EnumSet.of(KEEP_THE_BEAT, CUE)).add()
        Minigame("packingPests", "Packing Pests", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("ringside", "Ringside", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("samuraiSlice", "Samurai Slice (Fever)", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("screwbotFactory", "", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("seeSaw", "See-Saw", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("shrimpShuffle", "Shrimp Shuffle", EnumSet.of(FEVER), EnumSet.of(KEEP_THE_BEAT, CUE)).add()
        Minigame("tambourine", "Tambourine", EnumSet.of(FEVER), EnumSet.of(CUE)).add()
        Minigame("tapTroupe", "Tap Troupe", EnumSet.of(FEVER), EnumSet.of(KEEP_THE_BEAT)).add()
        Minigame("workingDough", "Working Dough", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CALL_AND_RESPONSE)).add()

        Minigame("animalAcrobat", "Animal Acrobat", EnumSet.of(MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("blueBear", "Blue Bear", EnumSet.of(MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("catchyTune", "Catchy Tune", EnumSet.of(MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("firstContact", "First Contact", EnumSet.of(MEGAMIX), EnumSet.of(CALL_AND_RESPONSE)).add()
        Minigame("fruitBasket", "Fruit Basket", EnumSet.of(MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("karateManSenior", "Karate Man Senior", EnumSet.of(MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("kitties", "Kitties!", EnumSet.of(MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("lumbearjack", "LumBEARjack", EnumSet.of(MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("pajamaParty", "Pajama Party", EnumSet.of(MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("sumoBrothers", "Sumo Brothers", EnumSet.of(MEGAMIX), EnumSet.of(KEEP_THE_BEAT, CUE)).add()
        Minigame("superSamuraiSlice", "Super Samurai Slice", EnumSet.of(MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("tangotronic3000", "Tangotronic 3000", EnumSet.of(MEGAMIX), EnumSet.of(CUE)).add()
        Minigame("tongueLashing", "Tongue Lashing", EnumSet.of(MEGAMIX), EnumSet.of(CUE)).add()

        Minigame("basketballGirls", "Basketball Girls", EnumSet.of(FEVER), EnumSet.of(CUE), true).add()
        Minigame("chameleon", "Chameleon", EnumSet.of(FEVER), EnumSet.of(CUE), true).add()
        Minigame("clapTrap", "Clap Trap", EnumSet.of(FEVER, MEGAMIX), EnumSet.of(CUE), true).add()
        Minigame("coinToss", "Coin Toss", EnumSet.of(DS, MEGAMIX), EnumSet.of(CUE), true).add()
        Minigame("drummingPractice", "Drumming Practice", EnumSet.of(MEGAMIX), EnumSet.of(CUE), true).add()
        Minigame("flickingPractice", "Flicking Practice", EnumSet.of(DS), EnumSet.of(CUE), true).add()
        Minigame("frogPrincess", "Frog Princess", EnumSet.of(FEVER), EnumSet.of(CUE), true).add()
        Minigame("glassTappers", "Glass Tappers", EnumSet.of(DS), EnumSet.of(CALL_AND_RESPONSE), true).add()
        Minigame("headSpinner", "Head Spinner / Mannequin", EnumSet.of(TENGOKU), EnumSet.of(CUE), true).add()
        Minigame("kungFuBall", "Kung Fu Ball", EnumSet.of(FEVER), EnumSet.of(KEEP_THE_BEAT, CUE), true).add()
        Minigame("ladyCupid", "Lady Cupid", EnumSet.of(FEVER), EnumSet.of(CUE), true).add()
        Minigame("manzaiBirds", "Manzai Birds", EnumSet.of(FEVER), EnumSet.of(CUE), true).add()
        Minigame("mrUpbeat", "Mr. Upbeat", EnumSet.of(TENGOKU, FEVER), EnumSet.of(KEEP_THE_BEAT), true).add()
        Minigame("munchyMonkEndless", "Munchy Monk (Endless)", EnumSet.of(FEVER), EnumSet.of(CUE), true).add()
        Minigame("pirateCrew", "Pirate Crew", EnumSet.of(FEVER), EnumSet.of(KEEP_THE_BEAT), true).add()
        Minigame("tunnel", "Tunnel", EnumSet.of(DS), EnumSet.of(KEEP_THE_BEAT), true).add()

    }

}