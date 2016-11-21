/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper5.exercise1.bank;

import java.io.Serializable;
/**
 *
 * @author Florian
 */
public interface IAccount extends Serializable {

    String getIban();

    int getBalance();
}
