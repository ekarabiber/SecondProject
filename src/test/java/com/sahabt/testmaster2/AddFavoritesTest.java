package com.sahabt.testmaster2;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddFavoritesTest extends Base {

    @Test
    public void LoggingIn (){

    new AddFavorites(webDriver).LoggingIn("eda@eda.com","eda1234","Daniel Wellington 0209Dw Erkek Kol Saati");

    }
}