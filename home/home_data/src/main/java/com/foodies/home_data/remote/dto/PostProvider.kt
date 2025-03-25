package com.foodies.home_data.remote.dto

import com.foodies.home_domain.model.Post

object PostProvider {
    fun getPosts(): List<Post> {
        return listOf(
            Post(
                id = 1,
                imageUrl = "https://images.unsplash.com/photo-1490645935967-10de6ba17061?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Zm9vZHxlbnwwfHwwfHx8MA%3D%3D",
                description = "Enjoying a delicious meal!",
                likes = 10,
                username = "foodie_lover_1",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 2,
                imageUrl = "https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8Zm9vZHxlbnwwfHwwfHx8MA%3D%3D",
                description = "Having a great day!",
                likes = 5,
                username = "gourmet_gal",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 3,
                imageUrl = "https://images.unsplash.com/photo-1490645935967-10de6ba17061?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Zm9vZHxlbnwwfHwwfHx8MA%3D%3D",
                description = "Cooking something new!",
                likes = 15,
                username = "chef_at_home",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 4,
                imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Relaxing after work.",
                likes = 25,
                username = "relaxing_eater",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 5,
                imageUrl = "https://images.unsplash.com/photo-1495147466023-ac5c588e2e94?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Having fun with friends.",
                likes = 45,
                username = "party_foodie",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 6,
                imageUrl = "https://images.unsplash.com/photo-1490645935967-10de6ba17061?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Zm9vZHxlbnwwfHwwfHx8MA%3D%3D",
                description = "Trying out a new recipe.",
                likes = 30,
                username = "experiment_cook",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 7,
                imageUrl = "https://images.unsplash.com/photo-1506084868230-bb9d95c24759?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjN8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Weekend vibes!",
                likes = 20,
                username = "weekend_foodie",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 8,
                imageUrl = "https://images.unsplash.com/photo-1493770348161-369560ae357d?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjV8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Just had the best coffee.",
                likes = 12,
                username = "coffee_lover_7",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 9,
                imageUrl = "https://images.unsplash.com/photo-1476224203421-9ac39bcb3327?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjl8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Exploring new places.",
                likes = 38,
                username = "food_explorer",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 10,
                imageUrl = "https://images.unsplash.com/photo-1490645935967-10de6ba17061?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Zm9vZHxlbnwwfHwwfHx8MA%3D%3D",
                description = "Enjoying the sunset.",
                likes = 55,
                username = "sunset_foodie",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 11,
                imageUrl = "https://images.unsplash.com/photo-1467003909585-2f8a72700288?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzJ8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Delicious brunch!",
                likes = 42,
                username = "brunch_fan",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 12,
                imageUrl = "https://images.unsplash.com/photo-1498837167922-ddd27525d352?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzR8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "A perfect day for a walk.",
                likes = 18,
                username = "walking_foodie",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 13,
                imageUrl = "https://images.unsplash.com/photo-1484723091739-30a097e8f929?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mzd8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Making some art.",
                likes = 33,
                username = "artistic_eater",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 14,
                imageUrl = "https://images.unsplash.com/photo-1504754524776-8f4f37790ca0?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDB8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Time for a snack!",
                likes = 28,
                username = "snack_lover",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 15,
                imageUrl = "https://images.unsplash.com/photo-1505252585461-04db1eb84625?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDh8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Reading a good book.",
                likes = 11,
                username = "bookish_foodie",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 16,
                imageUrl = "https://images.unsplash.com/photo-1455619452474-d2be8b1e70cd?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTV8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Late night coding session.",
                likes = 60,
                username = "coding_foodie",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 17,
                imageUrl = "https://images.unsplash.com/photo-1432139509613-5c4255815697?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NjB8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Working on a new project.",
                likes = 19,
                username = "project_foodie",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 18,
                imageUrl = "https://images.unsplash.com/photo-1490645935967-10de6ba17061?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Zm9vZHxlbnwwfHwwfHx8MA%3D%3D",
                description = "Enjoying some music.",
                likes = 48,
                username = "music_foodie",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 19,
                imageUrl = "https://images.unsplash.com/photo-1481070555726-e2fe8357725c?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NzB8fGZvb2R8ZW58MHx8MHx8fDA%3D",
                description = "Meeting new people.",
                likes = 22,
                username = "social_foodie",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            ),
            Post(
                id = 20,
                imageUrl = "https://images.unsplash.com/photo-1490645935967-10de6ba17061?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Zm9vZHxlbnwwfHwwfHx8MA%3D%3D",
                description = "Just finished a workout.",
                likes = 37,
                username = "workout_foodie",
                comments = (0..15).random(),
                carbs = (20..100).random(), // Generate random carbs
                protein = (10..50).random(), // Generate random protein
                fat = (5..40).random() // Generate random fat
            )
        )
    }
}