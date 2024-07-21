# Trivia Quiz API

## Description
The Trivia Quiz application allows users to answer trivia questions and track their scores. The application stores user score data, manages the leaderboard, and provides instant feedback on whether answers are correct or incorrect. Questions are generated using the Trivia API (https://opentdb.com/api_config.php).

## Key Features
1. Answering Questions: Users can answer trivia questions.
2. Score Storage: Scores for each answer are stored and updated.
3. Leaderboard: Displays the top 5 users based on their scores.
4. Answer Feedback: Provides feedback on whether the user's answer is correct or incorrect.

## Score Functionality in the Trivia Quiz 
### Answering question
1. When a user answers a question, the application calls a method to add a score based on that answer.
2. The type of answer for question is false or true
3. When you finish answer 10 questions, the message of "Congratulations!" will appear.

### Adding Score :
1. The 'addScore' method in 'ScoreService' is called each time a user answers a question.
2. If this is the user's first answer, a new score entry will be created for them.
3. If the user already has a score entry, it will be updated with the new answer.

### Score Logic :
1. Each time a user answers a question, their total score is updated.
2. If the answer is correct:
   - The 'correctStreak' (consecutive correct answers) is incremented by 1.
   - The user's total score is increased by the value of 'correctStreak'.
   - The 'incorrectStreak' is reset to 0.
3. If the answer is incorret:
   - The 'incorrectStreak' (consecutive incorrect answers) is incremented by 1.
   - The user's total score is decreased by the value of 'incorrectStreak'.
   - The 'correctStreak' is reset to 0.




Note : 
Feel free if you want to try! I already share sql and collection postman. I use mySqlDriver for depedency tool.
The Trivia API didn't have the answer for question, so I search the google for the answer.
