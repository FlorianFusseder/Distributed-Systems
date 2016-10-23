/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper1.exercise3.parkhaus;

/**
 *
 * @author Florian Fußeder
 */
public class Paper1Exercise3Parkhaus
{

    public static void main(String[] args)
    {
        Parkhaus ph = new Parkhaus(10);
        for (int i = 1; i <= 20; i++)
        {
            new Auto("Auto-­‐" + i, ph);
        }
    }
}
