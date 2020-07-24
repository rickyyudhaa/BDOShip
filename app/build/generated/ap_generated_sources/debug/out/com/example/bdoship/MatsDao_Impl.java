package com.example.bdoship;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class MatsDao_Impl implements MatsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfMaterial;

  public MatsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMaterial = new EntityInsertionAdapter<Material>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `material_table`(`id`,`name`,`image`,`price`,`qtyperday`,`barter`,`daily`,`coin`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Material value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getImage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImage());
        }
        stmt.bindLong(4, value.getPrice());
        stmt.bindLong(5, value.getQtyperday());
        final int _tmp;
        _tmp = value.isBarter() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final int _tmp_1;
        _tmp_1 = value.isDaily() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        final int _tmp_2;
        _tmp_2 = value.isCoin() ? 1 : 0;
        stmt.bindLong(8, _tmp_2);
      }
    };
  }

  @Override
  public void insert(Material mats) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMaterial.insert(mats);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Material> getAll() {
    final String _sql = "SELECT * From material_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
      final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
      final int _cursorIndexOfQtyperday = _cursor.getColumnIndexOrThrow("qtyperday");
      final int _cursorIndexOfBarter = _cursor.getColumnIndexOrThrow("barter");
      final int _cursorIndexOfDaily = _cursor.getColumnIndexOrThrow("daily");
      final int _cursorIndexOfCoin = _cursor.getColumnIndexOrThrow("coin");
      final List<Material> _result = new ArrayList<Material>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Material _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpImage;
        _tmpImage = _cursor.getString(_cursorIndexOfImage);
        final int _tmpPrice;
        _tmpPrice = _cursor.getInt(_cursorIndexOfPrice);
        final int _tmpQtyperday;
        _tmpQtyperday = _cursor.getInt(_cursorIndexOfQtyperday);
        final boolean _tmpBarter;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfBarter);
        _tmpBarter = _tmp != 0;
        final boolean _tmpDaily;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfDaily);
        _tmpDaily = _tmp_1 != 0;
        final boolean _tmpCoin;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfCoin);
        _tmpCoin = _tmp_2 != 0;
        _item = new Material(_tmpName,_tmpImage,_tmpPrice,_tmpBarter,_tmpDaily,_tmpCoin,_tmpQtyperday);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
