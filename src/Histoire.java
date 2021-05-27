import java.awt.*;

public class Histoire {

    public Histoire() {
    }

    public void renduN1(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Ink Free", Font.BOLD, 25));
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        g2d.drawString("Il était une fois...", ((GamePanel.LARGEUR_ECRAN/2) - metrics.stringWidth("Il était une fois...") / 2), 3 * GamePanel.GROSSEUR_UNITE);
        g2d.setFont(new Font("Ink Free", Font.BOLD, 15));
        FontMetrics metrics2 = g2d.getFontMetrics(g2d.getFont());
        g2d.drawString("Steve Jobs who ? An imposter I tell you.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("Steve Jobs who ? An imposter I tell you.") / 2), 5 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("After Dog invented Apple with his assistant, Mr. Jobs,", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("After Dog invented Apple with his assistant, Mr. Jobs,") / 2), 7 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("he suddenly woke up one morning to find out that all of his work had been stolen. ", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("he suddenly woke up one morning to find out that all of his work had been stolen. ") / 2), 9 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("He tried to get credit for his work in a court of law, but prejudice for cats runs deep.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("He tried to get credit for his work in a court of law, but prejudice for cats runs deep.") / 2), 11 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("No one believed a cat could have come up with this genius invention.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("No one believed a cat could have come up with this genius invention.") / 2), 13 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("“ You may be named Dog, Mx. Dog, but everyone here knows what you really are… A cat.” ", ((GamePanel.LARGEUR_ECRAN/2) -
                        metrics2.stringWidth("“ You may be named Dog, Mx. Dog, but everyone here knows what you really are… A cat.” ") / 2), 15 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("- Envy", ((GamePanel.LARGEUR_ECRAN/2) -
                        metrics2.stringWidth("- Envy") / 2), 15 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("Appuyer sur la touche 'd' pour sortir.", ((GamePanel.LARGEUR_ECRAN/2) -
                        metrics2.stringWidth("Appuyer sur la touche 'd' pour sortir.") / 2), 15 * GamePanel.GROSSEUR_UNITE);

    }

    public void renduN2(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Ink Free", Font.BOLD, 25));
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        g2d.drawString("Il était une fois...", ((GamePanel.LARGEUR_ECRAN/2) - metrics.stringWidth("Il était une fois...") / 2), 3 * GamePanel.GROSSEUR_UNITE);
        g2d.setFont(new Font("Ink Free", Font.BOLD, 14));
        FontMetrics metrics2 = g2d.getFontMetrics(g2d.getFont());
        g2d.drawString("During world war two, Dog was a spy for the British. But twist ! ", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("During world war two, Dog was a spy for the British. But twist ! ") / 2), 5 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("He also worked for the Japanese. At the end of the war, it had done absolutely nothing.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("He also worked for the Japanese. At the end of the war, it had done absolutely nothing.") / 2), 7 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString(" It just enjoyed the Chaos as he gave fake information to both sides.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth(" It just enjoyed the Chaos as he gave fake information to both sides.") / 2), 9 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("He also killed Hitler because he stole his catnip.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("He also killed Hitler because he stole his catnip.") / 2), 11 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("Dog knows no moral reasons, but no one touches the catnip.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("Dog knows no moral reasons, but no one touches the catnip.") / 2), 13 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("- Wrath", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("- Wrath") / 2), 15 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("Appuyer sur la touche 'd' pour sortir.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("Appuyer sur la touche 'd' pour sortir.") / 2), 17 * GamePanel.GROSSEUR_UNITE);

    }

    public void renduN3(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Ink Free", Font.BOLD, 25));
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        g2d.drawString("Il était une fois...", ((GamePanel.LARGEUR_ECRAN/2) - metrics.stringWidth("Il était une fois...") / 2), 2 * GamePanel.GROSSEUR_UNITE);
        g2d.setFont(new Font("Ink Free", Font.BOLD, 10));
        FontMetrics metrics2 = g2d.getFontMetrics(g2d.getFont());
        g2d.drawString("18h century America, as a new born country slowly figures out how to actually make independance work,", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("18h century America, as a new born country slowly figures out how to actually make independance work,") / 2), 4 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString(" a single cat makes it its life long goal to find the best snack there is.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth(" a single cat makes it its life long goal to find the best snack there is.") / 2), 5 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("After thousands of years of fishes and mice, Dog figures there might be more to life than bloody animal carcasses rotting in its basement.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("After thousands of years of fishes and mice, Dog figures there might be more to life than bloody animal carcasses rotting in its basement.") / 2), 6 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString(" You may have heard of Thomas Jefferson’s obsession with Mac and Cheese, so intense that it actually got banned from government meetings.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth(" You may have heard of Thomas Jefferson’s obsession with Mac and Cheese, so intense that it actually got banned from government meetings.") / 2), 7 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("The source of that deep rooted love comes from none other than our favorite feline.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("The source of that deep rooted love comes from none other than our favorite feline.") / 2), 8 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("After years of searching and scavenging, travelling the world and playing with death, Dog finds the snack above all snacks : milk.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("After years of searching and scavenging, travelling the world and playing with death, Dog finds the snack above all snacks : milk.") / 2), 9 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("But Thomas Jefferson had no taste buds and stayed fixed on his mac and cheese obsession, even after Dog introduced him to milk. ", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("But Thomas Jefferson had no taste buds and stayed fixed on his mac and cheese obsession, even after Dog introduced him to milk. ") / 2), 10 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("Which means in the end that this story leads nowhere, and Dog had nothing to do with the mac and cheese history or the second president of the United States.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("Which means in the end that this story leads nowhere, and Dog had nothing to do with the") / 2), 11 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString(" mac and cheese story or the second president of the United States.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth(" mac and cheese story or the second president of the United States.") / 2), 12 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("- Sloth", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("- Sloth") / 2), 14 * GamePanel.GROSSEUR_UNITE);
        g2d.drawString("Appuyer sur la touche 'd' pour sortir.", ((GamePanel.LARGEUR_ECRAN/2) -
                metrics2.stringWidth("Appuyer sur la touche 'd' pour sortir.") / 2), 15 * GamePanel.GROSSEUR_UNITE);

    }
}
