package bf.isge.gaming.quizz.utils;

import bf.isge.gaming.quizz.domain.Choix;
import bf.isge.gaming.quizz.domain.Partie;
import bf.isge.gaming.quizz.domain.Question;
import bf.isge.gaming.quizz.model.ChoixModel;
import bf.isge.gaming.quizz.model.PartieModel;
import bf.isge.gaming.quizz.model.QuestionModel;

import java.io.Serializable;

public class DataMapping implements Serializable {
    public static QuestionModel toQuestionModel(Question question){
        QuestionModel questionModel= new QuestionModel();
        questionModel.setId(question.getId());
        questionModel.setEnonce(question.getEnonce());
        questionModel.setChoix(question.getChoix());
        return questionModel;
    };

    public static Question fromQuestionModel(QuestionModel questionModel){
        Question question= new Question();
        question.setId(questionModel.getId());
        question.setEnonce(questionModel.getEnonce());
        question.setChoix(questionModel.getChoix());
        return question;
    };

    public static Choix fromChoixModel(ChoixModel choixModel){
        Choix choix= new Choix();
        choix.setIdChoix(choixModel.getId());
        choix.setDesignation(choixModel.getDesignation());
        choix.setBonChoix(choixModel.isBonChoix());
        return choix;
    };

    public static PartieModel toPartieModel(Partie partie){
        PartieModel partieModel= new PartieModel();
        partieModel.setId(partie.getId());
        partieModel.setScore(partie.getScore());
        partieModel.setDateCreation(partie.getDateCreation());
        partieModel.setQuestions(partie.getQuestions());

        return partieModel;
    };
}
