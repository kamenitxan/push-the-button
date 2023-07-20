package cz.kamenitxan.templateapp.controler

import java.sql.Connection
import java.util

import com.google.gson.{Gson, GsonBuilder}
import cz.kamenitxan.jakon.core.configuration.{DeployMode, Settings}
import cz.kamenitxan.jakon.core.controller.IController
import cz.kamenitxan.jakon.core.database.DBHelper
import cz.kamenitxan.jakon.core.template.TemplateEngine
import cz.kamenitxan.jakon.core.template.utils.TemplateUtils
import cz.kamenitxan.jakon.logging.Logger
import cz.kamenitxan.templateapp.entity.Button

import scala.collection.JavaConverters._

/**
 * Created by TPa on 2019-08-24.
 */
class ButtonsController extends IController {

	private implicit val cls: Class[Button] = classOf[Button]

	private val template = "raw"
	private val gson = if (Settings.getDeployMode == DeployMode.DEVEL) {
		new GsonBuilder().setPrettyPrinting().create
	} else {
		new Gson()
	}

	 val ALL_WORDS_SQL = "SELECT * FROM Button"

	def generate(): Unit = {
		val e: TemplateEngine = TemplateUtils.getEngine

		DBHelper.withDbConnection(implicit conn => {
			val stmt = conn.createStatement()
			val words = DBHelper.selectDeep(stmt, ALL_WORDS_SQL)
			val context = Map[String, AnyRef](
				"content" -> gson.toJson(words.asJava)
			)
			e.render(template, "words.json", context)
		})

	}
}

object ButtonsController {
	val ALL_WORDS_SQL = "SELECT * FROM Button"
}
