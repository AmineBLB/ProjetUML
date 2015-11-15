package simpledraw; /**
 * simpledraw.Main program of SimpleDraw
 * @author Rémi Bastide
 * @version 1.0
 */


/**
 * Refactoriser ce programme de manière à utiliser:
 * 
 * 
 * Le design pattern Composite
 *      Permettre l'implémentation du grouper / dégrouper :
 *      Manipuler (déplacer/supprimer) un groupe de formes comme une forme unique
 * 
 * Le design pattern MVC
 *      Permettre de visualiser le dessin de différentes manières
 *      ex: niveaux de zoom différents dans différentes fenêtres
 *      ex: une vue qui affiche : "il y a 3 cercles et 2 lignes dans le dessin
 * 
 * Le Design Pattern Visitor
 *      Permettre par exemple la sauvegarde du dessin en XML, JSON ...
 * 
 *
 * --> Fonctionnalité à rajouter : Grouper / Dégrouper
 * --> Rendu attendu
 *      Modèle UML mis à jour, mettant en évidence les design patterns utilisés
 *      Implémentation sous la forme d'un projet NetBeans
 *      Explication sur l'usage des design patterns
 *          Comment ils permettraient d'ajouter des nouvelles vues, d'implementer
 *          la sauvegarde
 *      15 Jours après la rentrée
 * 
 * @author boulbamo
 */

public class Main {
	/**Construct the application*/
	public Main() {
		MainFrame frame = new MainFrame();
		frame.validate();
		frame.setVisible(true);
		System.out.println(this.getClass().equals(super.getClass()));

	}

	/**simpledraw.Main method*/
	public static void main(String[] args) {
		new Main();
	}
}
