import java.awt.*;

public class Instruction {

    public Instruction() {
    }

    public void rendu(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Ink Free", Font.BOLD, 25));
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        g2d.drawString("Instruction", ((GamePanel.LARGEUR_ECRAN/2) - metrics.stringWidth("Instruction") / 2), 3 * GamePanel.GROSSEUR_UNITE);
        g2d.setFont(new Font("Ink Free", Font.BOLD, 15));
        FontMetrics metrics2 = g2d.getFontMetrics(g2d.getFont());
        g2d.drawString("Dog le chat s'est perdu (encore), peux-tu l'aider à trouver la sortie?? ", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("Dog le chat s'est perdu (encore), peux-tu l'aider à trouver la sortie??") / 2), 5 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("Utilise les flèches du clavier pour te déplacer.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("Utilise les flèches du clavier pour te déplacer.") / 2), 7 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("Fais attention au laser, utilise les blocs pour dévier leur direction.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("Fais attention au laser, utilise les blocs pour dévier leur direction.") / 2), 9 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("Appuyer sur la touche espace pour mettre le jeu sur pause. Essaie d'attraper toutes les proies!", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("Appuyer sur la touche espace pour mettre le jeu sur pause. Essaie d'attraper toutes les proies!") / 2), 11 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("Pour commencer le jeu, Appuyer sur le numéro du niveau auquel tu veux accéder.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("Pour commencer le jeu, Appuyer sur le numéro du niveau auquel tu veux accéder.") / 2), 13 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("Pour quitter les instructions ou pour les voir à nouveau, Appuyer sur 'f'", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("Pour quitter les instructions ou pour les voir à nouveau, Appuyer sur 'f'") / 2), 15 * GamePanel.GROSSEUR_UNITE);

    }
}
