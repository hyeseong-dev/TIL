import os
import shutil
import fire


class Dir():

    @staticmethod
    def get_cur_path(path=None):
        return os.getcwd() if path is None else path

    def mkdir(self, parentdir=None, names=None, file=None):

        print("디렉토리: 생성을 진행하겠습니다. ")
        print("디렉토리를 생성하고자하는 부모 디렉토리", parentdir)
        print(f"생성하고자 하는 디렉토리: {names}")
        # 빈리스트일 경우 None 반환

        if not names:
            print("파라미터를 다시 입력하여주세요.")
        # try:        
            # 현재 경로
        cwd = Dir.get_cur_path(parentdir)

        for dir_name in names:
            # 현재 경로에 리스트의 생성하고자 하는 디렉토리명이 없을 경우 생성
            if not Dir.path_exist_or_not(dir_name):
                file_path = os.path.join(cwd, dir_name)
                os.mkdir(file_path)
                self.mkfile(file_path, file)
        print("디렉토리 생성 완료")
        # except OSError:
        #     print('디렉토리 생성중 오류가 발생했습니다.')

    def rmdir(self, names):
        print("디렉토리: 삭제를 진행하겠습니다. ")
        print(f"삭제하고자 하는 디렉토리: {names}")
        # 빈리스트일 경우 None 반환
        if not names:
            print("파라미터를 다시 입력하여주세요.")
        # try:        
            # 현재 경로
        cwd = os.getcwd()
        try:
            for dir_name in names:
                # 현재 경로에 리스트의 생성하고자 하는 디렉토리명이 없을 경우 생성
                if Dir.path_exist_or_not(dir_name):
                    abs_path = os.path.join(cwd, dir_name)
                    shutil.rmtree(abs_path)
            print("디렉토리 삭제 완료")
        except OSError:
            print('디렉토리 삭제중 오류가 발생했습니다.')

    @staticmethod
    def path_exist_or_not(dir_name):
        return os.path.exists(dir_name)

    def mkfile(self, path, file=".gitkeep"):
        file = ".gitkeep" if file is None else file
        with open(f"{path}/{file}", 'w') as fp:
            pass

    def mkfiles(self, names):
        sep = Dir.seperator()
        file_list = names.split(sep)
        if not file_list:
            print("파일을 다시 입력해주세요.")
        path = Dir.get_cur_path()
        for file in file_list:
            self.mkfile(path, file)

    @staticmethod
    def seperator(name=','):
        return name if name is not None else ','


if __name__ == "__main__":
    fire.Fire(Dir)
