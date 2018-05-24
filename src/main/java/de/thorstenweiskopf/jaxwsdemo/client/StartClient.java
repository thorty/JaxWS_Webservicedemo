/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.thorstenweiskopf.jaxwsdemo.client;

/**
 *
 * @author MVC6
 */
public class StartClient {
    public static void main(String[] args) {
        MyWsClient client = new MyWsClient();
        client.callWebservice();
    }
}
