package com.example.liveinlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Personality_test extends AppCompatActivity {

    TextView questionTextView;
    RadioGroup optionsRadioGroup;
    Button nextButton;
    TextView Answer;

    Question[] questions;
    int currentQuestionIndex;

    int countOfAs;
    int countOfBs;

    int tot_count;

    static StringBuilder personality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_test);

        // Initialize UI elements
        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        nextButton = findViewById(R.id.nextButton);
        //Answer = findViewById(R.id.answerTextView);

        // Initialize questions
        questions = new Question[]{
                new Question("At a party, do you:", new String[]{"a. Interact with many, including strangers", "b. Interact with a few, known to you"}),
                new Question("Are you more:", new String[]{"a. Realistic than speculative", "b. Speculative than realistic"}),
                new Question("Is it worse to:", new String[]{"a. Have your 'head in the clouds'", "b. Be 'in a rut'"}),
                new Question("Are you more impressed by:", new String[]{"a. Principles", "b. Emotions"}),
                new Question("Are more drawn toward the:", new String[]{"a. Convincing", "b. Touching"}),
                new Question("Do you prefer to work:", new String[]{"a. To deadlines", "b. Just “whenever”"}),
                new Question("Do you tend to choose:", new String[]{"a. Rather carefully", "b. Somewhat impulsively"}),
                new Question("At parties do you:", new String[]{"a. Stay late, with increasing energy", "b. Leave early with decreased energy"}),
                new Question("Are you more attracted to:", new String[]{"a. Sensible people", "b. Imaginative people"}),
                new Question("Are you more interested in:", new String[]{"a. What is actual", "b. What is possible"}),
                new Question("In judging others are you more swayed by:", new String[]{"a. Laws than circumstances", "b. Circumstances than laws"}),
                new Question("In approaching others is your inclination to be somewhat:", new String[]{"a. Objective", "b. Personal"}),
                new Question("Are you more:", new String[]{"a. Punctual", "b. Leisurely"}),
                new Question("Does it bother you more having things:", new String[]{"a. Incomplete", "b. Completed"}),
                new Question("In your social groups do you:", new String[]{"a. Keep abreast of other’s happenings", "b. Get behind on the news"}),
                new Question("In doing ordinary things are you more likely to:", new String[]{"a. Do it the usual way", "b. Do it your own way"}),
                new Question("Writers should:", new String[]{"a. Say what they mean and mean what they say", "b. Express things more by use of analogy"}),
                new Question("Which appeals to you more:", new String[]{"a. Consistency of thought", "b. Consistency of thought"}),
                new Question("Are you more comfortable in making:", new String[]{"a. Logical judgments", "b. Value judgments"}),
                new Question("Do you want things:", new String[]{"a. Settled and decided", "b. Unsettled and undecided"}),
                new Question("Would you say you are more", new String[]{"a. Serious and determined", "b. Easy-going"}),
                new Question("In phoning do you:", new String[]{"a. Rarely question that it will all be said", "b. Rehearse what you’ll say"}),
                new Question("Facts:", new String[]{"a. Speak for themselves", "b. Illustrate principles"}),
                new Question("Are visionaries:", new String[]{"a. somewhat annoying", "b. rather fascinating"}),
                new Question("Are you more often:", new String[]{"a. a cool-headed person", "b. a warm-hearted person"}),
                new Question("Is it worse to be:", new String[]{"a. unjust", "b. merciless"}),
                new Question("Should one usually let events occur:", new String[]{"a. by careful selection and choice", "b. randomly and by chance"}),
                new Question("Do you feel better about:", new String[]{"a. having purchased", "b. having the option to buy"}),
                new Question("In company do you:", new String[]{"a. initiate conversation", "b. wait to be approached"}),
                new Question("Common sense is:", new String[]{"a. rarely questionable", "b. frequently questionable"}),
                new Question("Children often do not::", new String[]{"a. make themselves useful enough", "b. exercise their fantasy enough"}),
                new Question("In making decisions do you feel more comfortable with:", new String[]{"a. standards", "b. feelings"}),
                new Question("Are you more:", new String[]{"a. firm than gentle", "b. gentle than firm"}),
                new Question("Which is more admirable:", new String[]{"a. the ability to organize and be methodical", "b. the ability to adapt and make do"}),
                new Question("Do you put more value on:", new String[]{"a. infinite", "b. open-minded"}),
                new Question("Does new and non-routine interaction with others:", new String[]{"a. stimulate and energize you", "b. tax your reserves"}),
                new Question("Are you more frequently:", new String[]{"a. a practical sort of person", "b. a fanciful sort of person"}),
                new Question("Are you more likely to:", new String[]{"a. see how others are useful", "b. see how others see"}),
                new Question("Which is more satisfying:", new String[]{"a. to discuss an issue thoroughly", "b. to arrive at agreement on an issue"}),
                new Question("Which rules you more:", new String[]{"a. your head", "b. your heart"}),
                new Question("Are you more comfortable with work that is:", new String[]{"a. contracted", "b. done on a casual basis"}),
                new Question("Do you tend to look for:", new String[]{"a. the orderly", "b. whatever turns up"}),
                new Question("Do you prefer:", new String[]{"a. many friends with brief contact", "b. a few friends with more lengthy contact"}),
                new Question("Do you go more by:", new String[]{"a. facts", "b. principles"}),
                new Question("Are you more interested in:", new String[]{"a. production and distribution", "b. design and research"}),
                new Question("Which is more of a compliment:", new String[]{"a. “There is a very logical person.”", "b. “There is a very sentimental person.”"}),
                new Question("Do you value in yourself more that you are:", new String[]{"a. unwavering", "b. devoted"}),
                new Question("Do you more often prefer the:", new String[]{"a. final and unalterable statement", "b. tentative and preliminary statement"}),
                new Question("Are you more comfortable:", new String[]{"a. after a decision", "b. before a decision"}),
                new Question("Do you:", new String[]{"a. speak easily and at length with strangers", "b. find little to say to strangers"}),
                new Question("Are you more likely to trust your:", new String[]{"a. experience", "b. hunch"}),
                new Question("Do you feel:", new String[]{"a. more practical than ingenious", "b. more ingenious than practical"}),
                new Question("Which person is more to be complimented one of:", new String[]{"a. clear reason", "b. strong feeling"}),
                new Question("Are you inclined more to be:", new String[]{"a. fair-minded", "b. sympathetic"}),
                new Question("Is it preferable mostly to:", new String[]{"a. make sure things are arranged", "b. just let things happen"}),
                new Question("In relationships should most things be:", new String[]{"a. re-negotiable", "b. random and circumstantial"}),
                new Question("When the phone rings do you:", new String[]{"a. hasten to get to it first", "b. sympathetic"}),
                new Question("Are you inclined more to be:", new String[]{"a. a strong sense of reality", "b. a vivid imagination"}),
                new Question("Do you prize more in yourself:", new String[]{"a. fair-minded'", "b. sympathetic"}),
                new Question("Are you drawn more to:", new String[]{"a. fundamentals", "b. overtones"}),
                new Question("Which seems the greater error:", new String[]{"a. to be too passionate", "b. to be too objective"}),
                new Question("Do you see yourself as basically:", new String[]{"a. hard-headed", "b. soft-hearted"}),
                new Question("Which situation appeals to you more:", new String[]{"a. the structured and scheduled", "b. the unstructured and unscheduled"}),
                new Question("Are you a person that is more:", new String[]{"a. routinized than whimsical", "b. whimsical than routinized"}),
                new Question("Are you more inclined to be:", new String[]{"a. easy to approach", "b. somewhat reserved"}),
                new Question("In writings do you prefer:", new String[]{"a. the more literal", "b. the more figurative"}),
                new Question("Is it harder for you to:", new String[]{"a. identify with others", "b. utilize others"}),
                new Question("Which do you wish more for yourself:", new String[]{"a. clarity of reason", "b. strength of compassion"}),
                new Question("Which is the greater fault:", new String[]{"a. being indiscriminate", "b. being critical"}),
                new Question("Do you prefer the:", new String[]{"a. planned event", "b. unplanned event"}),
                new Question("Do you tend to be more:", new String[]{"a. deliberate than spontaneous", "b. spontaneous than deliberate"}),
        };

        currentQuestionIndex = 0;
        countOfAs = 0;
        countOfBs = 0;
        tot_count = 0;
        personality = new StringBuilder();

        showQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Process user response
                int checkedRadioButtonId = optionsRadioGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(checkedRadioButtonId);
                    String answer = selectedRadioButton.getText().toString();
                    String answer_1 = String.valueOf(answer.charAt(0));
                    //Answer.setText(answer_1);
                    // Update counts based on user response
                    updateCounts(answer_1);

                    // Move to the next question or display personality result
                    if (currentQuestionIndex < questions.length)
                    {
                        showQuestion();
                        currentQuestionIndex+=7;
                    }
                    else if((currentQuestionIndex>=questions.length) && tot_count==0)
                    {
                        tot_count++;
                        displayResult_1();
                    }
                    else if((currentQuestionIndex>=questions.length) && tot_count==1)
                    {
                        tot_count++;
                        currentQuestionIndex=2;
                    }
                    else if((currentQuestionIndex>=questions.length) && tot_count==2)
                    {
                        tot_count++;
                        displayResult_2();
                    }
                    else if((currentQuestionIndex>=questions.length) && tot_count==3)
                    {
                        tot_count++;
                        currentQuestionIndex=4;
                    }
                    else if((currentQuestionIndex>=questions.length) && tot_count==4)
                    {
                        tot_count++;
                        displayResult_3();
                    }
                    else if((currentQuestionIndex>=questions.length) && tot_count==5)
                    {
                        tot_count++;
                        currentQuestionIndex=6;
                    }
                    else if((currentQuestionIndex>=questions.length) && tot_count==6)
                    {
                        tot_count++;
                        displayResult_4();
                    }
                }
            }
        });
    }

    private void showQuestion() {
        // Display the current question
        questionTextView.setText(questions[currentQuestionIndex].getQuestion());

        // Clear previous radio button selection
        optionsRadioGroup.clearCheck();

        // Add radio buttons dynamically based on the question options
        optionsRadioGroup.removeAllViews();
        for (String option : questions[currentQuestionIndex].getOptions()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setTextAppearance(android.R.style.TextAppearance_DeviceDefault_Medium);
            radioButton.setText(option);
            optionsRadioGroup.addView(radioButton);
        }
    }

    public void updateCounts(String answer) {
        if (answer.equalsIgnoreCase("a")) {
            countOfAs++;
        } else if (answer.equalsIgnoreCase("b")) {
            countOfBs++;
        }
    }

    private void displayResult_1() {
        // Determine personality type based on counts
        if (countOfAs > countOfBs) {
            personality.append("E ");
        } else {
            personality.append("I ");
        }
        countOfAs=0;
        countOfBs=0;
        currentQuestionIndex=1;
        //Answer.setText(personality);
    }

    private void displayResult_2() {
        // Determine personality type based on x`counts
        if (countOfAs > countOfBs) {
            personality.append("S ");
        } else {
            personality.append("N ");
        }
        countOfAs=0;
        countOfBs=0;
        currentQuestionIndex=3;
        //Answer.setText(personality);
    }

    private void displayResult_3() {
        // Determine personality type based on x`counts
        if (countOfAs > countOfBs) {
            personality.append("T ");
        } else {
            personality.append("F ");
        }
        countOfAs=0;
        countOfBs=0;
        currentQuestionIndex=5;
    }

    private void displayResult_4() {
        // Determine personality type based on x`counts
        if (countOfAs > countOfBs) {
            personality.append("J ");
        } else {
            personality.append("P ");
        }
        countOfAs=0;
        countOfBs=0;
        nextButton.setText("SUBMIT");
        final Context context = this;
        nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, Personality_Result.class);
            startActivity(intent);
        });
    }

}