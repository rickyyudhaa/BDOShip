package com.example.bdoship;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class Bdoshipdb_Impl extends Bdoshipdb {
  private volatile ShipDao _shipDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ship_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` TEXT, `material` TEXT, `inventory` INTEGER NOT NULL, `cabins` INTEGER NOT NULL, `cannonballs` INTEGER NOT NULL, `cannons` INTEGER NOT NULL, `lt` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `inventory` INTEGER NOT NULL, `ships` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `material_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `image` TEXT, `price` INTEGER NOT NULL, `barter` INTEGER NOT NULL, `daily` INTEGER NOT NULL, `coin` INTEGER NOT NULL, FOREIGN KEY(`id`) REFERENCES `ship_table`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"40203b5a2da354c05497bf77a0a69d7e\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `ship_table`");
        _db.execSQL("DROP TABLE IF EXISTS `user_table`");
        _db.execSQL("DROP TABLE IF EXISTS `material_table`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsShipTable = new HashMap<String, TableInfo.Column>(8);
        _columnsShipTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsShipTable.put("type", new TableInfo.Column("type", "TEXT", false, 0));
        _columnsShipTable.put("material", new TableInfo.Column("material", "TEXT", false, 0));
        _columnsShipTable.put("inventory", new TableInfo.Column("inventory", "INTEGER", true, 0));
        _columnsShipTable.put("cabins", new TableInfo.Column("cabins", "INTEGER", true, 0));
        _columnsShipTable.put("cannonballs", new TableInfo.Column("cannonballs", "INTEGER", true, 0));
        _columnsShipTable.put("cannons", new TableInfo.Column("cannons", "INTEGER", true, 0));
        _columnsShipTable.put("lt", new TableInfo.Column("lt", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysShipTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesShipTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoShipTable = new TableInfo("ship_table", _columnsShipTable, _foreignKeysShipTable, _indicesShipTable);
        final TableInfo _existingShipTable = TableInfo.read(_db, "ship_table");
        if (! _infoShipTable.equals(_existingShipTable)) {
          throw new IllegalStateException("Migration didn't properly handle ship_table(com.example.bdoship.Ship).\n"
                  + " Expected:\n" + _infoShipTable + "\n"
                  + " Found:\n" + _existingShipTable);
        }
        final HashMap<String, TableInfo.Column> _columnsUserTable = new HashMap<String, TableInfo.Column>(3);
        _columnsUserTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsUserTable.put("inventory", new TableInfo.Column("inventory", "INTEGER", true, 0));
        _columnsUserTable.put("ships", new TableInfo.Column("ships", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserTable = new TableInfo("user_table", _columnsUserTable, _foreignKeysUserTable, _indicesUserTable);
        final TableInfo _existingUserTable = TableInfo.read(_db, "user_table");
        if (! _infoUserTable.equals(_existingUserTable)) {
          throw new IllegalStateException("Migration didn't properly handle user_table(com.example.bdoship.User).\n"
                  + " Expected:\n" + _infoUserTable + "\n"
                  + " Found:\n" + _existingUserTable);
        }
        final HashMap<String, TableInfo.Column> _columnsMaterialTable = new HashMap<String, TableInfo.Column>(7);
        _columnsMaterialTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsMaterialTable.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsMaterialTable.put("image", new TableInfo.Column("image", "TEXT", false, 0));
        _columnsMaterialTable.put("price", new TableInfo.Column("price", "INTEGER", true, 0));
        _columnsMaterialTable.put("barter", new TableInfo.Column("barter", "INTEGER", true, 0));
        _columnsMaterialTable.put("daily", new TableInfo.Column("daily", "INTEGER", true, 0));
        _columnsMaterialTable.put("coin", new TableInfo.Column("coin", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMaterialTable = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysMaterialTable.add(new TableInfo.ForeignKey("ship_table", "NO ACTION", "NO ACTION",Arrays.asList("id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesMaterialTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMaterialTable = new TableInfo("material_table", _columnsMaterialTable, _foreignKeysMaterialTable, _indicesMaterialTable);
        final TableInfo _existingMaterialTable = TableInfo.read(_db, "material_table");
        if (! _infoMaterialTable.equals(_existingMaterialTable)) {
          throw new IllegalStateException("Migration didn't properly handle material_table(com.example.bdoship.Material).\n"
                  + " Expected:\n" + _infoMaterialTable + "\n"
                  + " Found:\n" + _existingMaterialTable);
        }
      }
    }, "40203b5a2da354c05497bf77a0a69d7e", "2a4adba0b26144ae1828db43100ddb21");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "ship_table","user_table","material_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `ship_table`");
      _db.execSQL("DELETE FROM `user_table`");
      _db.execSQL("DELETE FROM `material_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ShipDao shipDao() {
    if (_shipDao != null) {
      return _shipDao;
    } else {
      synchronized(this) {
        if(_shipDao == null) {
          _shipDao = new ShipDao_Impl(this);
        }
        return _shipDao;
      }
    }
  }
}
