package com.example.cukcuklitedemo.data.source.Bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cukcuklitedemo.data.model.ColorBackground;
import com.example.cukcuklitedemo.data.model.Product;
import com.example.cukcuklitedemo.data.model.Unit;
import com.example.cukcuklitedemo.data.source.IProductDataSource;

import java.util.ArrayList;
import java.util.List;

public class ProductHelper implements IProductDataSource {

    private static ProductHelper sInstance;
    ProductOpenHelper openHelper;

    private final String TABLE_PRODUCT = " product ";
    private final String TABLE_UNIT = " unit ";
    private final String TABLE_BACKGROUND_COLOR = " background_color ";

    private final String COLUMN_UNIT_ID = "unit_id";
    private final String COLUMN_UNIT_NAME = "unit_name";
    private final String COLUMN_IS_CHOSE = "is_chose";

    private final String COLUMN_BACKGROUND_ID = "background_id";
    private final String COLUMN_BACKGROUND_COLOR = "backgroud_color";

    private final String COLUMN_PRODUCT_ID = "product_id";
    private final String COLUMN_PRODUCT_NAME = "product_name";
    private final String COLUMN_PRODUCT_PRICE = "product_price";
    private final String COLUMN_ICON_NAME = "icon_name";


    private ProductHelper(Context context) {
        if (openHelper == null)
            openHelper = ProductOpenHelper.getInstance(context);
        openHelper.onCreateDatabase();
    }

    public static ProductHelper getInstance(Context context) {
        if (sInstance == null) sInstance = new ProductHelper(context);
        return sInstance;
    }


    @Override
    public List<Product> getListProduct() {

        String sql = "SELECT * FROM product p join unit u On p.unit_id = u.unit_id join background_color b on p.backgroud_id = b.background_id ";
        List<Product> products = new ArrayList<>();
        try {
            if (openHelper.getDatabase() != null && openHelper.getDatabase().isOpen()) {
                Cursor cursor = openHelper.getDatabase().rawQuery(sql, null);
                if (cursor.moveToFirst()) {
                    while (!cursor.isAfterLast()) {

                        Unit unit = new Unit();
                        unit.setUnitId(cursor.getInt(cursor.getColumnIndex(COLUMN_UNIT_ID)));
                        unit.setUnitName(cursor.getString(cursor.getColumnIndex(COLUMN_UNIT_NAME)));
                        unit.setIsChose(cursor.getInt(cursor.getColumnIndex(COLUMN_IS_CHOSE)));

                        ColorBackground colorBackground = new ColorBackground();
                        colorBackground.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_BACKGROUND_ID)));
                        colorBackground.setContent(cursor.getString(cursor.getColumnIndex(COLUMN_BACKGROUND_COLOR)));

                        Product product = new Product();
                        product.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_PRODUCT_ID)));
                        product.setProductName(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_NAME)));
                        product.setProductPrice(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_PRICE)));
                        product.setIconName(cursor.getString(cursor.getColumnIndex(COLUMN_ICON_NAME)));
                        product.setBackground(colorBackground);
                        product.setUnit(unit);

                        products.add(product);

                        cursor.moveToNext();
                    }
                }
                cursor.close();
                openHelper.closeDB();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<ColorBackground> getListColorBackground() {
        String sql = "SELECT * FROM background_color";
        List<ColorBackground> colorBackgrounds = new ArrayList<>();
        try {

            if (openHelper.getDatabase() != null && openHelper.getDatabase().isOpen()) {
                Cursor cursor = openHelper.getDatabase().rawQuery(sql, null);
                if (cursor.moveToFirst()) {
                    while (!cursor.isAfterLast()) {

                        ColorBackground colorBackground = new ColorBackground();
                        colorBackground.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_BACKGROUND_ID)));
                        colorBackground.setContent(cursor.getString(cursor.getColumnIndex(COLUMN_BACKGROUND_COLOR)));

                        colorBackgrounds.add(colorBackground);

                        cursor.moveToNext();
                    }
                }
                cursor.close();
                openHelper.closeDB();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colorBackgrounds;
    }

    @Override
    public List<Unit> getListUnit() {
        String sql = "SELECT * FROM " + TABLE_UNIT;
        List<Unit> units = new ArrayList<>();
        try {
            if (openHelper.getDatabase() != null && openHelper.getDatabase().isOpen()) {
                Cursor cursor = openHelper.getDatabase().rawQuery(sql, null);
                if (cursor.moveToFirst()) {
                    while (!cursor.isAfterLast()) {

                        Unit unit = new Unit();
                        unit.setUnitId(cursor.getInt(cursor.getColumnIndex(COLUMN_UNIT_ID)));
                        unit.setUnitName(cursor.getString(cursor.getColumnIndex(COLUMN_UNIT_NAME)));
                        unit.setIsChose(cursor.getInt(cursor.getColumnIndex(COLUMN_IS_CHOSE)));
                        units.add(unit);

                        cursor.moveToNext();
                    }
                }
                cursor.close();
                openHelper.closeDB();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return units;
    }

    @Override
    public boolean insertProduct(Product product) {

        boolean createSuccessful = false;
        try {
            ContentValues values = new ContentValues();

            values.put(COLUMN_PRODUCT_NAME, product.getProductName());
            values.put(COLUMN_PRODUCT_PRICE, product.getProductPrice());
            values.put(COLUMN_UNIT_ID, product.getUnit().getUnitId());
            values.put("backgroud_id", product.getBackground().getId());
            values.put(COLUMN_ICON_NAME, product.getIconName());
            SQLiteDatabase db = openHelper.getDatabase();

            createSuccessful = db.insert(TABLE_PRODUCT, null, values) > 0;
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return createSuccessful;
    }

    @Override
    public boolean updateProduct(Product product) {

        boolean updateSuccessful = false;
        try {
            ContentValues values = new ContentValues();
            values.put(COLUMN_PRODUCT_NAME, product.getProductName());
            values.put(COLUMN_PRODUCT_PRICE, product.getProductPrice());
            values.put(COLUMN_UNIT_ID, product.getUnit().getUnitId());
            values.put("backgroud_id", product.getBackground().getId());
            values.put(COLUMN_ICON_NAME, product.getIconName());
            SQLiteDatabase db = openHelper.getDatabase();

            updateSuccessful = db.update(TABLE_PRODUCT, values, COLUMN_PRODUCT_ID + " = ? ", new String[]{String.valueOf(product.getId())}) > 0;
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return updateSuccessful;
    }

    @Override
    public boolean deleteProduct(int productId) {
        boolean deleteSuccessful = false;
        try {
            SQLiteDatabase db = openHelper.getDatabase();
            deleteSuccessful = db.delete(TABLE_PRODUCT, COLUMN_PRODUCT_ID + " = ?", new String[]{String.valueOf(productId)}) > 0;
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteSuccessful;

    }

    @Override
    public boolean insertUnit(Unit unit) {
        return false;
    }

    @Override
    public boolean updateUnit(Unit unit) {
        return false;
    }

    @Override
    public boolean deleteUnit(int productId) {
        return false;
    }
}
