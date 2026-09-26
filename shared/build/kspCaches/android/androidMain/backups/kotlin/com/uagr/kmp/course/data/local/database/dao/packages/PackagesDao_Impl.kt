package com.uagr.kmp.course.`data`.local.database.dao.packages

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performInTransactionSuspending
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.uagr.kmp.course.`data`.local.model.packages.PackagesEntity
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class PackagesDao_Impl(
  __db: RoomDatabase,
) : PackagesDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfPackagesEntity: EntityInsertAdapter<PackagesEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfPackagesEntity = object : EntityInsertAdapter<PackagesEntity>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `packages` (`id`,`name`,`description`,`price`,`currency`,`stock`,`created_by`,`created_at`) VALUES (?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: PackagesEntity) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.name)
        statement.bindText(3, entity.description)
        statement.bindText(4, entity.price)
        statement.bindText(5, entity.currency)
        statement.bindText(6, entity.stock)
        statement.bindText(7, entity.created_by)
        statement.bindText(8, entity.created_at)
      }
    }
  }

  public override suspend fun insertPackages(packages: List<PackagesEntity>): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfPackagesEntity.insert(_connection, packages)
  }

  public override suspend fun clearAndInsertPackages(packages: List<PackagesEntity>): Unit = performInTransactionSuspending(__db) {
    super@PackagesDao_Impl.clearAndInsertPackages(packages)
  }

  public override suspend fun getPackages(): List<PackagesEntity> {
    val _sql: String = "SELECT * FROM packages"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfDescription: Int = getColumnIndexOrThrow(_stmt, "description")
        val _columnIndexOfPrice: Int = getColumnIndexOrThrow(_stmt, "price")
        val _columnIndexOfCurrency: Int = getColumnIndexOrThrow(_stmt, "currency")
        val _columnIndexOfStock: Int = getColumnIndexOrThrow(_stmt, "stock")
        val _columnIndexOfCreatedBy: Int = getColumnIndexOrThrow(_stmt, "created_by")
        val _columnIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "created_at")
        val _result: MutableList<PackagesEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: PackagesEntity
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpDescription: String
          _tmpDescription = _stmt.getText(_columnIndexOfDescription)
          val _tmpPrice: String
          _tmpPrice = _stmt.getText(_columnIndexOfPrice)
          val _tmpCurrency: String
          _tmpCurrency = _stmt.getText(_columnIndexOfCurrency)
          val _tmpStock: String
          _tmpStock = _stmt.getText(_columnIndexOfStock)
          val _tmpCreated_by: String
          _tmpCreated_by = _stmt.getText(_columnIndexOfCreatedBy)
          val _tmpCreated_at: String
          _tmpCreated_at = _stmt.getText(_columnIndexOfCreatedAt)
          _item = PackagesEntity(_tmpId,_tmpName,_tmpDescription,_tmpPrice,_tmpCurrency,_tmpStock,_tmpCreated_by,_tmpCreated_at)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteAllPackages() {
    val _sql: String = "DELETE FROM packages"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
