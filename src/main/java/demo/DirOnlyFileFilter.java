package demo;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.file.filters.FileListFilter;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author pobedenniy.alexey
 * @since 23.02.2015
 */
public class DirOnlyFileFilter implements FileListFilter<File> {
	protected static final Logger log = LoggerFactory.getLogger(DirOnlyFileFilter.class);

	@Override
	public List<File> filterFiles(File[] files) {
		return Lists.newLinkedList(Iterables.filter(Arrays.asList(files), new Predicate<File>() {
			@Override
			public boolean apply(@Nullable File input) {
				return !input.isDirectory() && !"tmp".equals(FilenameUtils.getExtension(input.getName()));
			}
		}));
	}
}
