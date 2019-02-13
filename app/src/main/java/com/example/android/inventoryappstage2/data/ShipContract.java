package com.example.android.inventoryappstage2.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class ShipContract {

    private ShipContract() {
    }

    public static final String CONTENT_AUTHORITY = "com.example.android.inventoria";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_SHIPS = "ships";



    public static abstract class ShipsEntry implements BaseColumns {

        public static final String TABLE_NAME = "ships";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_SHIPS);


        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHIPS;


        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHIPS;

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_STARSHIP_NAME = "name";
        public static final String COLUMN_STARSHIP_PRICE = "price";
        public static final String COLUMN_STARSHIP_QUANTITY = "quantity";
        public static final String COLUMN_STARSHIP_SUPPLIER = "supplier";
        public static final String COLUMN_STARSHIP_PHONE = "phone";


        public static final int STARSHIP_UNKNOWN = 0;
        public static final int STARSHIP_USS_ENTERPRISE = 1;
        public static final int STARSHIP_ROMULAN_WARBIRD = 2;
        public static final int STARSHIP_KLINGON_BIRD_OF_PREY = 3;
        public static final int STARSHIP_BORG_CUBE = 4;
        public static final int STARSHIP_USS_PROMETHEUS = 5;

        public static boolean isValidStarship (int starship) {
            if (starship == STARSHIP_UNKNOWN || starship == STARSHIP_USS_ENTERPRISE || starship == STARSHIP_ROMULAN_WARBIRD ||
                    starship == STARSHIP_KLINGON_BIRD_OF_PREY || starship == STARSHIP_BORG_CUBE ||
                    starship == STARSHIP_USS_PROMETHEUS) {
                return true;
            }
            return false;
        }

        private static final String TEXT_TYPE = " TEXT";
        private static final String INTERGER_TYPE = " INTEGER";
        private static final String MONEY_TYPE = " MONEY";
        private static final String PKA = " PRIMARY KEY AUTOINCREMENT";
        private static final String DEFAULT = " DEFAULT";
        private static final String NOT_NULL = " NOT NULL";
        public static final String NULL = " NULL";
        private static final String COMMA_SEP = ",";

        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ShipsEntry.TABLE_NAME +
                " (" + ShipsEntry._ID + INTERGER_TYPE + PKA + COMMA_SEP + ShipsEntry.COLUMN_STARSHIP_NAME +
                INTERGER_TYPE + NOT_NULL + COMMA_SEP + COLUMN_STARSHIP_PRICE + MONEY_TYPE + NOT_NULL +
                COMMA_SEP + COLUMN_STARSHIP_QUANTITY + INTERGER_TYPE + NOT_NULL + DEFAULT + " 0" + COMMA_SEP +
                COLUMN_STARSHIP_SUPPLIER + TEXT_TYPE + COMMA_SEP + COLUMN_STARSHIP_PHONE + INTERGER_TYPE +
                NOT_NULL + " )" + ";";

        public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ShipsEntry.TABLE_NAME;
    }
}
