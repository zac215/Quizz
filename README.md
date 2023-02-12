# Quizz
Ce projet comporte l'API d'une application de quizz. 

## Pré-requis
Avoir Postgresql fonctionnant sur le port 5432.
Créer une base de données nommée e_concours nommée quizz.
Le fichier ex.sql contient des données exemples à importer.

## Fonctionnement

### Question
Pour créer une question, envoie le corps de la question sous la forme ci-dessus dans une requête post à localhost:8082/api/question. 
{
	"enonce": "Vrai ou Faux"
}

### Choix
Pour enregistrer les choix possibles pour une question, on envoie la liste des corps des choix sous la forme ci-dessus dans une requête post à localhost:8082/api/choix.

[
	{
		"designation": "Étienne de la Boétie",
		"bonChoix": false
	},
	{
		"designation": "Voltaire",
		"bonChoix": false
	},
	{
		"designation": "Montaigne",
		"bonChoix": true
	}
	
]

### Partie
Pour obtenir une nouvelle partie, on envoie une requête GET sur http://localhost:8082/question.
Pour jouer une partie on envoie la liste de ses reponses( choix) sur http://localhost:8082/choix/answer avec une requete post
[
	{
		"id": 1,

	},
	{
		"id": 2
	},
	{
		"id": 3
	},
	{
		"id": 5
	},
	{
		"id": 4
	},
	
	
]



